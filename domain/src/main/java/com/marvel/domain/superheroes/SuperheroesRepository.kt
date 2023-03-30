/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.domain.superheroes

import com.marvel.domain.superheroes.model.Superhero

interface SuperheroesRepository {
    fun refreshSuperheroes(): List<Superhero>
}
