/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.domain.superheroes.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Superhero(
    val name: String,
    val description: String,
    val imageUrl: String,
) : Parcelable
