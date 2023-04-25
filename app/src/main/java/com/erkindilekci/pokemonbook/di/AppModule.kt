package com.erkindilekci.pokemonbook.di

import com.erkindilekci.pokemonbook.data.remote.PokemonApi
import com.erkindilekci.pokemonbook.repository.PokemonRepository
import com.erkindilekci.pokemonbook.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePokemonRepo(api: PokemonApi) = PokemonRepository(api)

    @Provides
    @Singleton
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create()) // This will convert Json code to data class
            .baseUrl(BASE_URL)
            .build()
            .create(PokemonApi::class.java)
    }
}