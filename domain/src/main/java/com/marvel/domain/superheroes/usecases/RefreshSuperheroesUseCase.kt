/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.domain.superheroes.usecases

import com.marvel.domain.superheroes.SuperheroesRepository

class RefreshSuperheroesUseCase(
    private val superheroesRepository: SuperheroesRepository,
) {
    suspend fun execute() =
        superheroesRepository.refreshSuperheroes()
}
