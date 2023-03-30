/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.data.superheroes.datasources

import com.marvel.domain.superheroes.model.Superhero

interface LocalSuperheroesDataSource {
    fun saveSuperheroes(superheroes: List<Superhero>)
}
