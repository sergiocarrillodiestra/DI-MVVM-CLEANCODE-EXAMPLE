package com.dscorp.mvvmexample.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dscorp.mvvmexample.domain.entity.Pokemon
import com.dscorp.mvvmexample.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: PokemonRepository) :
    ViewModel() {
    private val pokemons = MutableLiveData<List<Pokemon>>()

    init {
        getpokemons()
    }

    private fun getpokemons() {
        viewModelScope.launch {
            pokemons.value = repository.getPokemons()
        }

    }

    fun pokemons(): LiveData<List<Pokemon>> {
        return pokemons
    }


}