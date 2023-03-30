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
    val name: String,
    val description: String,
    val imageUrl: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
