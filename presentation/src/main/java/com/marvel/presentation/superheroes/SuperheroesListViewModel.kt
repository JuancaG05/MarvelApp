/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.presentation.superheroes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.domain.superheroes.model.Superhero
import com.marvel.domain.superheroes.usecases.RefreshSuperheroesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SuperheroesListViewModel(
    private val refreshSuperheroesUseCase: RefreshSuperheroesUseCase,
) : ViewModel() {
    private val _superheroesList: MutableStateFlow<List<Superhero>> = MutableStateFlow(emptyList())
    val superheroesList: StateFlow<List<Superhero>> = _superheroesList

    init {
        refreshSuperheroes()
    }

    fun refreshSuperheroes() {
        viewModelScope.launch(Dispatchers.IO) {
            val refreshedSuperheroes = refreshSuperheroesUseCase.execute()
            _superheroesList.update { refreshedSuperheroes }
        }
    }
}
