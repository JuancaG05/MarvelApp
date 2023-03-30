/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.data.superheroes.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "superheroes"
)
data class SuperheroEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
)
