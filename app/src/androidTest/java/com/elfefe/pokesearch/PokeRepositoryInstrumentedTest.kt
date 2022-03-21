package com.elfefe.pokesearch

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.elfefe.pokesearch.mvvm.repository.PokeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class PokeRepositoryInstrumentedTest {
    @Test
    fun pokerepository_query_all_pokemons() {
        // Context of the app under test.
        val scope = CoroutineScope(Dispatchers.IO)
        val repository = PokeRepository(scope)
        repository.getPokemons().onEach {
            assert(it.isNotEmpty())
            if (it.size == 50) assert(it.size == 50)
        }.launchIn(scope)
    }
}