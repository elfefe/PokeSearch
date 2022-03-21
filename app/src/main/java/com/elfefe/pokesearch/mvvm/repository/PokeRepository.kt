package com.elfefe.pokesearch.mvvm.repository

import android.util.Log
import android.widget.GridLayout.Spec
import com.elfefe.pokesearch.mvvm.model.PokeFilter
import com.elfefe.pokesearch.mvvm.model.Pokemon
import com.elfefe.pokesearch.mvvm.model.PokemonSpecie
import com.elfefe.pokesearch.mvvm.model.Specie
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokeRepository(private val scope: CoroutineScope) {
    private val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                useAlternativeNames = true
                ignoreUnknownKeys = true
            })
        }

        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
        }
    }

    fun getPokemons(parameters: String = "?limit=50&offset=0"): StateFlow<List<PokemonSpecie>> =
        MutableStateFlow<MutableList<PokemonSpecie>>(mutableListOf()).apply {
            scope.launch(Dispatchers.IO) {
                client.get<PokeFilter>("${URL}pokemon$parameters").results.forEach { pokeLink ->
                    client.get<Pokemon>(pokeLink.url).let { pokemon ->
                        if (!value.any { p -> p.pokemon.name == pokemon.name })
                            value = mutableListOf<PokemonSpecie>().apply {
                                val specie = client.get<Specie>("${URL}pokemon-species/${pokemon.id}")
                                Log.e(javaClass.simpleName, "${pokemon.name} color ${specie.color.name}")
                                addAll(value)
                                add(PokemonSpecie(pokemon, specie))
                            }
                    }
                }
            }
        }

    companion object {
        private const val URL = "https://pokeapi.co/api/v2/"
    }
}