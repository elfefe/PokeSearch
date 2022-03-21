package com.elfefe.pokesearch.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.elfefe.pokesearch.ui.activity.MainActivity
import com.elfefe.pokesearch.R
import com.elfefe.pokesearch.mvvm.model.Pokemon
import com.elfefe.pokesearch.mvvm.model.PokemonSpecie
import com.elfefe.pokesearch.mvvm.viewmodel.PokemonViewModel
import com.elfefe.pokesearch.ui.adapter.PokemonDescriptionAdapter
import com.elfefe.pokesearch.utils.resNameColor
import com.elfefe.pokesearch.utils.resString
import com.google.android.material.tabs.TabLayoutMediator

class PokemonFragment : Fragment() {
    private lateinit var activity: MainActivity
    private lateinit var viewModel: PokemonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity = requireActivity() as MainActivity
        viewModel = ViewModelProvider(this)[PokemonViewModel::class.java]
        return inflater.inflate(R.layout.fragment_pokemon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemon = arguments?.getParcelable<PokemonSpecie>(resString(R.string.pokemon_tag))
        val descriptions = listOf(
            resString(R.string.stats_label),
            resString(R.string.properties_label),
            resString(R.string.abilities_label)
        )
        (view as ViewGroup).run {
            pokemon?.pokemon?.run pokemon@{
                findViewById<ConstraintLayout>(R.id.layout_pokemon_presentation)
                    .background
                    .setTint(resNameColor(pokemon.specie.color.name))
                findViewById<TextView>(R.id.textview_presentation_name).text = name
                findViewById<TextView>(R.id.textview_presentation_type_1).text = types.first().type?.name
                if (types.size > 1)
                    findViewById<TextView>(R.id.textview_presentation_type_2).text = types[1].type?.name
                else {
                    findViewById<TextView>(R.id.textview_presentation_type_2).isVisible = false
                }
                findViewById<ImageView>(R.id.imageview_pokemon_picture).load(
                    sprites.front_default ?: sprites.front_female ?: sprites.other
                )
                val pager = findViewById<ViewPager2>(R.id.pager_pokemon_description).apply {
                    adapter = PokemonDescriptionAdapter(this@PokemonFragment, pokemon, descriptions)
                }
                TabLayoutMediator(
                    findViewById(R.id.tab_pokemon_description),
                    pager
                ) { tab, position ->
                    tab.text = descriptions[position]
                }.attach()
            }
        }
    }

    companion object {
        fun newInstance(bundle: Bundle.() -> Unit = {}): PokemonFragment =
            PokemonFragment().apply {
                arguments = Bundle().apply(bundle)
            }
    }
}