package com.erkindilekci.pokemonbook.repository

import com.erkindilekci.pokemonbook.data.remote.PokemonApi
import com.erkindilekci.pokemonbook.data.remote.responses.Pokemon
import com.erkindilekci.pokemonbook.data.remote.responses.PokemonList
import com.erkindilekci.pokemonbook.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(private val api: PokemonApi) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error(message = "An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error(message = "An unknown error occurred.")
        }
        return Resource.Success(response)
    }

}