package com.elfefe.pokesearch.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.elfefe.pokesearch.ui.activity.MainActivity
import com.elfefe.pokesearch.R
import com.elfefe.pokesearch.mvvm.model.Pokemon
import com.elfefe.pokesearch.mvvm.model.PokemonSpecie
import com.elfefe.pokesearch.mvvm.viewmodel.PokemonViewModel
import com.elfefe.pokesearch.utils.resString

class AbilitiesFragment : Fragment() {
    private lateinit var activity: MainActivity
    private lateinit var viewModel: PokemonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity = requireActivity() as MainActivity
        viewModel = ViewModelProvider(this)[PokemonViewModel::class.java]
        return inflater.inflate(R.layout.fragment_abilities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireArguments().getParcelable<PokemonSpecie>(resString(R.string.pokemon_tag))?.run {
            view.run {
                findViewById<LinearLayout>(R.id.layout_abilities_holder).run {
                    pokemon.abilities.forEach { ability ->
                        addView(TextView(context).apply {
                            text = ability.ability?.name
                        })
                        addView(View(context).apply {
                            minimumHeight = TypedValue.applyDimension(
                                TypedValue.COMPLEX_UNIT_DIP,
                                20f,
                                resources.displayMetrics
                            ).toInt()
                        })
                        invalidate()
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance(bundle: Bundle.() -> Unit = {}): AbilitiesFragment =
            AbilitiesFragment().apply {
                arguments = Bundle().apply(bundle)
            }
    }
}