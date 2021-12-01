package com.dscorp.mvvmexample.domain.entity

data class PokemonApiResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Pokemon>
)