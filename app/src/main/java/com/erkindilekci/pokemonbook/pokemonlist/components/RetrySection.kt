package com.erkindilekci.pokemonbook.pokemonlist.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RetrySection(
    error: String,
    onRetry: () -> Unit
) {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = error, color = Color.Red, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { onRetry }, modifier = Modifier.align(CenterHorizontally)) {
            Text(text = "Retry")
        }
    }
}