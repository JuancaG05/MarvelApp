/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.data.superheroes.network

data class SuperheroResponse(
    val data: SuperheroContainer,
)

data class SuperheroContainer(
    val results: List<SuperheroInstance>,
)

data class SuperheroInstance(
    val name: String,
    val description: String,
    val thumbnail: SuperheroImage,
)

data class SuperheroImage(
    val path: String,
    val extension: String,
)
