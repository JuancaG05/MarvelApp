/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.data.superheroes.datasources.implementation

import com.marvel.data.superheroes.database.SuperheroDao
import com.marvel.data.superheroes.database.SuperheroEntity
import com.marvel.data.superheroes.datasources.LocalSuperheroesDataSource
import com.marvel.domain.superheroes.model.Superhero

class LocalSuperheroesDataSourceImpl(
    private val superheroDao: SuperheroDao,
) : LocalSuperheroesDataSource {
    override fun saveSuperheroes(superheroes: List<Superhero>) {
        val superheroesEntities = superheroes.map { it.toEntity() }
        superheroDao.saveSuperheroes(superheroesEntities)
    }

    override fun getAllSuperheroes(): List<Superhero> {
        return superheroDao.getAllSuperheroesAsStream().map {it.toModel() }
    }

    private fun Superhero.toEntity() =
        SuperheroEntity(
            name = name,
            description = description,
            imageUrl = imageUrl,
        )

    private fun SuperheroEntity.toModel() =
        Superhero(
            name = name,
            description = description,
            imageUrl = imageUrl,
        )
}
