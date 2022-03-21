package com.elfefe.pokesearch.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.elfefe.pokesearch.ui.activity.MainActivity
import com.elfefe.pokesearch.R
import com.elfefe.pokesearch.mvvm.model.Pokemon
import com.elfefe.pokesearch.mvvm.model.PokemonSpecie
import com.elfefe.pokesearch.mvvm.viewmodel.PokemonViewModel
import com.elfefe.pokesearch.utils.resString

class PropertiesFragment : Fragment() {
    private lateinit var activity: MainActivity
    private lateinit var viewModel: PokemonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity = requireActivity() as MainActivity
        viewModel = ViewModelProvider(this)[PokemonViewModel::class.java]
        return inflater.inflate(R.layout.fragment_properties, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireArguments().getParcelable<PokemonSpecie>(resString(R.string.pokemon_tag))?.run {
            view.run {
                findViewById<TextView>(R.id.textview_properties_weight_value)
                    .text = resString(R.string.properties_weight_value, pokemon.weight)
                findViewById<TextView>(R.id.textview_properties_height_value)
                    .text = resString(R.string.properties_height_value, pokemon.height)
            }
        }
    }

    companion object {
        fun newInstance(bundle: Bundle.() -> Unit = {}): PropertiesFragment =
            PropertiesFragment().apply {
                arguments = Bundle().apply(bundle)
            }
    }
}