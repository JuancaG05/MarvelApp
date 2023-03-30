/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.domain.superheroes.model

data class Superhero(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
)
