package com.dscorp.mvvmexample.framweork.hilt.modules

import com.dscorp.mvvmexample.data.repositoryImp.PokemonRepositoryImpl
import com.dscorp.mvvmexample.data.retrofit.API.PokemonAPI
import com.dscorp.mvvmexample.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainActivityModule {

    @Provides
    @Singleton
    fun providesPokemonAPI(retrofit: Retrofit): PokemonAPI {
        return retrofit.create(PokemonAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesPokemonRepository(pokemonAPI: PokemonAPI): PokemonRepository {
        return PokemonRepositoryImpl(pokemonAPI)
    }

}