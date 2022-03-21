package com.elfefe.pokesearch.ui.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.elfefe.pokesearch.R
import com.elfefe.pokesearch.mvvm.model.Pokemon
import com.elfefe.pokesearch.mvvm.model.PokemonSpecie
import com.elfefe.pokesearch.ui.activity.MainActivity
import com.elfefe.pokesearch.ui.fragment.PokemonFragment
import com.elfefe.pokesearch.utils.resNameColor
import com.elfefe.pokesearch.utils.resString

class PokemonAdapter(
    private val activity: MainActivity,
    private var pokeLinks: List<PokemonSpecie>
) : RecyclerView.Adapter<PokemonAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false))

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.update(position)
    }

    override fun getItemCount(): Int = pokeLinks.size

    fun updatePokemons(doPokemons: (List<PokemonSpecie>) -> List<PokemonSpecie>) {
        pokeLinks = doPokemons(pokeLinks)
        notifyItemInserted(pokeLinks.size)
    }

    inner class Holder(private val item: View) : ViewHolder(item) {
        fun update(position: Int) {
            pokeLinks[position].run {
                item.background.setTint(resNameColor(specie.color.name))
                item.setOnClickListener {
                    activity.openFragment(PokemonFragment.newInstance {
                        putParcelable(
                            resString(R.string.pokemon_tag),
                            this@run
                        )
                    })
                }
                item.findViewById<ImageView>(R.id.imageview_picture).load(
                    pokemon.sprites.front_default ?: pokemon.sprites.front_female
                    ?: pokemon.sprites.other
                )
                item.findViewById<TextView>(R.id.textview_name).text = pokemon.name
                item.findViewById<TextView>(R.id.textview_order).text =
                    resString(R.string.pokemon_order, pokemon.order.toString())
                item.findViewById<TextView>(R.id.textview_type_first).text =
                    pokemon.types.first().type?.name
                if (pokemon.types.size > 1)
                    item.findViewById<TextView>(R.id.textview_type_second).text =
                        pokemon.types[1].type?.name
            }
        }
    }
}