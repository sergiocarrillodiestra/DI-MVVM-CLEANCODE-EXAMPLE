package com.dscorp.mvvmexample.data.repositoryImp

import android.util.Log
import com.dscorp.mvvmexample.data.retrofit.API.PokemonAPI
import com.dscorp.mvvmexample.domain.entity.Pokemon
import com.dscorp.mvvmexample.domain.repository.PokemonRepository

class PokemonRepositoryImpl(private val pokemonAPI: PokemonAPI) : PokemonRepository {
    override suspend fun getPokemons(): List<Pokemon> {
        val response = pokemonAPI.getAllPokemons();
        return if (response.isSuccessful && response.code() == 200) {
            response.body()!!.results
        } else {
            Log.e("PokemonRepostitoryImpl", "getPokemons: error responsecode code was ${response.code()} ", )
            emptyList()
        }
    }
}