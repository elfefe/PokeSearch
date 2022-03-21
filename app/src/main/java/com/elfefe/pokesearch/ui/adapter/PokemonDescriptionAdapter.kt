package com.elfefe.pokesearch.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.elfefe.pokesearch.R
import com.elfefe.pokesearch.mvvm.model.Pokemon
import com.elfefe.pokesearch.mvvm.model.PokemonSpecie
import com.elfefe.pokesearch.ui.fragment.AbilitiesFragment
import com.elfefe.pokesearch.ui.fragment.PropertiesFragment
import com.elfefe.pokesearch.ui.fragment.StatsFragment
import com.elfefe.pokesearch.utils.resString

class PokemonDescriptionAdapter(
    fragment: Fragment,
    private val pokemon: PokemonSpecie,
    private val descriptions: List<String>
): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = descriptions.size
    override fun createFragment(position: Int): Fragment =
        when (descriptions[position]) {
            resString(R.string.abilities_label) -> AbilitiesFragment.newInstance {
                putParcelable(resString(R.string.pokemon_tag), pokemon)
            }
            resString(R.string.properties_label) -> PropertiesFragment.newInstance {
                putParcelable(resString(R.string.pokemon_tag), pokemon)
            }
            else -> StatsFragment.newInstance {
                putParcelable(resString(R.string.pokemon_tag), pokemon)
            }
        }
}