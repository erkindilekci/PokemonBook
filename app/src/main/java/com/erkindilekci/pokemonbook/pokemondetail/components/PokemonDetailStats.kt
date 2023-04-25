package com.erkindilekci.pokemonbook.pokemondetail.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erkindilekci.pokemonbook.data.remote.responses.Pokemon
import com.erkindilekci.pokemonbook.util.parseStatToAbbr
import com.erkindilekci.pokemonbook.util.parseStatToColor

@Composable
fun PokemonStat(
    statName: String,
    statValue: Int,
    statMaxValue: Int,
    statColor: Color,
    height: Dp = 28.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember { mutableStateOf(false) }

    val curPercent = animateFloatAsState(
        targetValue = if (animationPlayed) statValue / statMaxValue.toFloat() else 0f,
        animationSpec = tween(animDuration, animDelay),
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .clip(CircleShape)
            .background(if (isSystemInDarkTheme()) Color(0xFF505050) else Color.LightGray)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(curPercent.value)
                .clip(CircleShape)
                .background(statColor)
                .padding(horizontal = 8.dp)
        ) {
            Text(text = statName, fontWeight = FontWeight.Bold)

            Text(
                text = (curPercent.value * statMaxValue).toInt().toString(),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun PokemonBaseStats(
    pokemonInfo: Pokemon,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember { pokemonInfo.stats.maxOf { it.baseStat } }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Base Stats", fontSize = 19.sp, color = MaterialTheme.colors.onSurface, fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.height(4.dp))

        pokemonInfo.stats.indices.forEach {
            val stat = pokemonInfo.stats[it]

            PokemonStat(
                statName = parseStatToAbbr(stat),
                statValue = stat.baseStat,
                statMaxValue = maxBaseStat,
                statColor = parseStatToColor(stat),
                animDelay = it*animDelayPerItem
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}