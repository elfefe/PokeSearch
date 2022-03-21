package com.elfefe.pokesearch.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elfefe.pokesearch.ui.activity.MainActivity
import com.elfefe.pokesearch.ui.adapter.PokemonAdapter
import com.elfefe.pokesearch.R
import com.elfefe.pokesearch.mvvm.viewmodel.PokemonViewModel

class MainFragment : Fragment() {
    private lateinit var activity: MainActivity
    private lateinit var viewModel: PokemonViewModel
    private lateinit var pokemonViewmodel: PokemonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity = requireActivity() as MainActivity
        viewModel = ViewModelProvider(this)[PokemonViewModel::class.java]
        pokemonViewmodel = ViewModelProvider(activity)[PokemonViewModel::class.java]
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemonAdapter = PokemonAdapter(activity, mutableListOf())
        view.findViewById<RecyclerView>(R.id.recyclerview_pokemons).run {
            adapter = pokemonAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL).apply {
                ResourcesCompat.getDrawable(resources, R.drawable.shape_pokemon_separator, null)
                    ?.let { drawable -> setDrawable(drawable) }
            })
        }
        pokemonViewmodel.queryPokemons().observe(viewLifecycleOwner) { pokemons ->
            pokemonAdapter.updatePokemons { pokemons }
        }
    }

    companion object {
        fun newInstance(bundle: Bundle.() -> Unit = {}): MainFragment =
            MainFragment().apply {
                arguments = Bundle().apply(bundle)
            }
    }
}