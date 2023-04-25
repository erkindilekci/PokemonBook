package com.erkindilekci.pokemonbook.pokemonlist.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.erkindilekci.pokemonbook.data.model.PokemonListEntry

@Composable
fun PokemonRow(
    rowIndex: Int,
    entries: List<PokemonListEntry>,
    navController: NavController
) {
    Column {
        Row() {
            PokemonEntry(entry = entries[rowIndex*2], navController = navController, modifier = Modifier.weight(1f))
            
            Spacer(modifier = Modifier.width(16.dp))

            if (entries.size >+ rowIndex*2+2) {
                PokemonEntry(entry = entries[rowIndex*2+1], navController = navController, modifier = Modifier.weight(1f))
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}