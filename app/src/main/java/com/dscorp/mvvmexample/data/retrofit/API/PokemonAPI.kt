package com.dscorp.mvvmexample.data.retrofit.API

import com.dscorp.mvvmexample.PublicVariables
import com.dscorp.mvvmexample.domain.entity.PokemonApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonAPI {
    @GET("${PublicVariables.POKEMON_API}pokemon")
    suspend fun  getAllPokemons():Response<PokemonApiResponse>
}
