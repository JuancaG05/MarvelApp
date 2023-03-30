/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.data.superheroes.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface SuperheroDao {
    @Insert(onConflict = REPLACE)
    fun saveSuperheroes(superheroes: List<SuperheroEntity>): List<Long>

    @Query(SELECT_ALL_SUPERHEROES)
    fun getAllSuperheroesAsStream(): List<SuperheroEntity>

    companion object {
        private const val SELECT_ALL_SUPERHEROES = """
            SELECT *
            FROM superheroes
        """
    }
}
