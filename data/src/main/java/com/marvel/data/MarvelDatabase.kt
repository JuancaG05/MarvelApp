/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marvel.data.superheroes.database.SuperheroDao
import com.marvel.data.superheroes.database.SuperheroEntity

@Database(
    entities = [SuperheroEntity::class],
    version = 1,
)
abstract class MarvelDatabase: RoomDatabase() {
    abstract fun superheroDao(): SuperheroDao

    companion object {
        @Volatile
        private var INSTANCE: MarvelDatabase? = null

        fun getDatabase(context: Context): MarvelDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    MarvelDatabase::class.java,
                    "marvel_database"
                )
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}
