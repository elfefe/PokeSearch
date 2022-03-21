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
import com.elfefe.pokesearch.R
import com.elfefe.pokesearch.mvvm.model.Pokemon
import com.elfefe.pokesearch.mvvm.model.PokemonSpecie
import com.elfefe.pokesearch.mvvm.viewmodel.PokemonViewModel
import com.elfefe.pokesearch.ui.adapter.StatsAdapter
import com.elfefe.pokesearch.utils.resString

class StatsFragment : Fragment() {
    private lateinit var activity: MainActivity
    private lateinit var viewModel: PokemonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity = requireActivity() as MainActivity
        viewModel = ViewModelProvider(this)[PokemonViewModel::class.java]
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireArguments().getParcelable<PokemonSpecie>(resString(R.string.pokemon_tag))?.run {
            view.run {
                findViewById<RecyclerView>(R.id.recyclerview_stats_desciption).run {
                    adapter = StatsAdapter(pokemon.stats)
                    layoutManager = LinearLayoutManager(context)
                    addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL).apply {
                        ResourcesCompat.getDrawable(resources, R.drawable.shape_pokemon_separator, null)
                            ?.let { drawable -> setDrawable(drawable) }
                    })
                }
            }
        }
    }

    companion object {
        fun newInstance(bundle: Bundle.() -> Unit = {}): StatsFragment =
            StatsFragment().apply {
                arguments = Bundle().apply(bundle)
            }
    }
}