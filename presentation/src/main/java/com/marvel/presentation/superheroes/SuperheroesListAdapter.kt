/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.presentation.superheroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.presentation.R
import com.marvel.presentation.databinding.ItemSuperheroCardBinding

class SuperheroesListAdapter(
    val onClick: () -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemSuperheroCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SuperheroCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val superheroCardViewHolder = holder as SuperheroCardViewHolder
        superheroCardViewHolder.binding.apply {
            superheroImage.setImageResource(R.drawable.captain_america)
            superheroName.text = "Captain America"
            superheroCard.setOnClickListener { onClick() }
        }
    }

    override fun getItemCount(): Int {
        return 1
    }

    class SuperheroCardViewHolder(val binding: ItemSuperheroCardBinding) : RecyclerView.ViewHolder(binding.root)
}
