package com.dscorp.mvvmexample.domain.repository

import com.dscorp.mvvmexample.data.retrofit.API.PokemonAPI
import com.dscorp.mvvmexample.domain.entity.Pokemon
import com.dscorp.mvvmexample.domain.entity.PokemonApiResponse

interface PokemonRepository {
    suspend fun  getPokemons():List<Pokemon>
}
