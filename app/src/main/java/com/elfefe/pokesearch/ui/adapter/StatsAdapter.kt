package com.elfefe.pokesearch.ui.adapter

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elfefe.pokesearch.R
import com.elfefe.pokesearch.mvvm.model.Stat

class StatsAdapter(val stats: List<Stat>): RecyclerView.Adapter<StatsAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_pokemon_stats, parent, false)
        )

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.update(position)
    }

    override fun getItemCount(): Int = stats.size

    inner class Holder(private val item: View) : RecyclerView.ViewHolder(item) {
        @SuppressLint("ClickableViewAccessibility")
        fun update(position: Int) {
            item.run {
                findViewById<TextView>(R.id.textview_stats_name).text = stats[position].stat?.name
                findViewById<TextView>(R.id.textview_stats_value).text = stats[position].baseStat.toString()
                findViewById<SeekBar>(R.id.seekbar_stats_value).run {
                    setOnTouchListener { _, _ -> true }
                    stats[position].baseStat.let { stat ->
                        max = 100
                        progress = stat.toInt()
                        progressDrawable.setTint(if (stat >= max / 2) Color.GREEN else Color.RED)
                    }
                }
            }
        }
    }
}