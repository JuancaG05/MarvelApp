/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.data.superheroes.datasources.implementation

import com.marvel.data.superheroes.datasources.RemoteSuperheroesDataSource
import com.marvel.data.superheroes.network.MarvelApi
import com.marvel.data.superheroes.network.SuperheroResponse
import com.marvel.domain.superheroes.model.Superhero

class RemoteSuperheroesDataSourceImpl : RemoteSuperheroesDataSource {
    override suspend fun refreshSuperheroes(): List<Superhero> {
        val superheroResponse = MarvelApi.retrofitService.getSuperheroes()
        return superheroResponse.toModel()
    }

    private fun SuperheroResponse.toModel(): List<Superhero> {
        val superheroes = mutableListOf<Superhero>()
        data.results.forEach { superheroInstance ->
            superheroes.add(
                Superhero(
                    name = superheroInstance.name,
                    description = superheroInstance.description,
                    imageUrl = superheroInstance.thumbnail.path + superheroInstance.thumbnail.extension
                )
            )
        }
        return superheroes
    }

}
