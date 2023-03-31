/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.data.superheroes.repository

import com.marvel.data.superheroes.datasources.LocalSuperheroesDataSource
import com.marvel.data.superheroes.datasources.RemoteSuperheroesDataSource
import com.marvel.domain.superheroes.SuperheroesRepository
import com.marvel.domain.superheroes.model.Superhero

class SuperheroesRepositoryImpl(
    private val localSuperheroesDataSource: LocalSuperheroesDataSource,
    private val remoteSuperheroesDataSource: RemoteSuperheroesDataSource,
) : SuperheroesRepository {
    override suspend fun refreshSuperheroes(): List<Superhero> {
        val superheroes = remoteSuperheroesDataSource.refreshSuperheroes()
        localSuperheroesDataSource.saveSuperheroes(superheroes)
        return superheroes
    }
}
