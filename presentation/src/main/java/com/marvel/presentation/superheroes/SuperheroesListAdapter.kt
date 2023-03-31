/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.presentation.superheroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.marvel.domain.superheroes.model.Superhero
import com.marvel.presentation.databinding.ItemSuperheroCardBinding

class SuperheroesListAdapter(
    val onClick: (Superhero) -> Unit,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val superheroesList = mutableListOf<Superhero>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemSuperheroCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SuperheroCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val superheroCardViewHolder = holder as SuperheroCardViewHolder
        superheroCardViewHolder.binding.apply {
            val superhero = superheroesList[position]
            superheroImage.load(superhero.imageUrl)
            superheroName.text = superhero.name
            superheroCard.setOnClickListener { onClick(superhero) }
        }
    }

    override fun getItemCount(): Int {
        return superheroesList.size
    }

    fun setData(superheroes: List<Superhero>) {
        superheroesList.clear()
        superheroesList.addAll(superheroes)
        notifyDataSetChanged()
    }

    class SuperheroCardViewHolder(val binding: ItemSuperheroCardBinding) : RecyclerView.ViewHolder(binding.root)
}
