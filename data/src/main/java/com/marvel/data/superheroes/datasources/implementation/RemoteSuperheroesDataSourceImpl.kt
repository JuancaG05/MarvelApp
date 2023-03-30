/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.data.superheroes.datasources.implementation

import com.marvel.data.superheroes.datasources.RemoteSuperheroesDataSource
import com.marvel.domain.superheroes.model.Superhero

class RemoteSuperheroesDataSourceImpl : RemoteSuperheroesDataSource {
    override fun refreshSuperheroes(): List<Superhero> {
        return listOf(
            Superhero(
                name = "Name 1",
                description = "Description 1",
                imageUrl = "none"
            ),
            Superhero(
                name = "Name 2",
                description = "Description 2",
                imageUrl = "none"
            )
        )
    }
}
