/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.presentation.dependencyinjection

import com.marvel.data.MarvelDatabase
import com.marvel.data.superheroes.datasources.LocalSuperheroesDataSource
import com.marvel.data.superheroes.datasources.RemoteSuperheroesDataSource
import com.marvel.data.superheroes.datasources.implementation.LocalSuperheroesDataSourceImpl
import com.marvel.data.superheroes.datasources.implementation.RemoteSuperheroesDataSourceImpl
import com.marvel.data.superheroes.repository.SuperheroesRepositoryImpl
import com.marvel.domain.superheroes.SuperheroesRepository
import com.marvel.domain.superheroes.usecases.RefreshSuperheroesUseCase
import com.marvel.presentation.superheroes.SuperheroesListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val generalModule = module {
    viewModel { SuperheroesListViewModel(get()) }
    factory { RefreshSuperheroesUseCase(get()) }
    factory<SuperheroesRepository> { SuperheroesRepositoryImpl(get(), get()) }
    factory<LocalSuperheroesDataSource> { LocalSuperheroesDataSourceImpl(get()) }
    single { MarvelDatabase.getDatabase(androidContext()).superheroDao() }
    factory<RemoteSuperheroesDataSource> { RemoteSuperheroesDataSourceImpl()}
}
