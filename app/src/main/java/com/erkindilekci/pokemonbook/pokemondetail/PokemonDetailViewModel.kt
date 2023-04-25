package com.erkindilekci.pokemonbook.pokemondetail

import androidx.lifecycle.ViewModel
import com.erkindilekci.pokemonbook.data.remote.responses.Pokemon
import com.erkindilekci.pokemonbook.repository.PokemonRepository
import com.erkindilekci.pokemonbook.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}   