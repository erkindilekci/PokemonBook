package com.erkindilekci.pokemonbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.erkindilekci.pokemonbook.presentation.ui.theme.PokemonBookTheme
import com.erkindilekci.pokemonbook.util.ComposeNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonBookTheme {
                ComposeNavigation()
            }
        }
    }
}
