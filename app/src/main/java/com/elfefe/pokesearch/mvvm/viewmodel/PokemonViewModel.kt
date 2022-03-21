package com.elfefe.pokesearch.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elfefe.pokesearch.mvvm.model.Pokemon
import com.elfefe.pokesearch.mvvm.model.PokemonSpecie
import com.elfefe.pokesearch.mvvm.model.Specie
import com.elfefe.pokesearch.mvvm.repository.PokeRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PokemonViewModel : ViewModel() {
    private val pokeRepository = PokeRepository(viewModelScope)

    fun queryPokemons(): LiveData<List<PokemonSpecie>> = MutableLiveData<List<PokemonSpecie>>().apply {
        pokeRepository
            .getPokemons()
            .onEach { pokemons ->
                postValue(pokemons)
            }
            .launchIn(viewModelScope)
    }
}