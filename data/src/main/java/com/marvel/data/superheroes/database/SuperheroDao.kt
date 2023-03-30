/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.data.superheroes.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SuperheroDao {
    @Query(SELECT_ALL_SUPERHEROES)
    fun getAllSuperheroesAsStream(): Flow<List<SuperheroEntity>>

    companion object {
        private const val SELECT_ALL_SUPERHEROES = """
            SELECT *
            FROM superheroes
        """
    }
}
