package com.erkindilekci.pokemonbook.util

import androidx.compose.ui.graphics.Color
import com.erkindilekci.pokemonbook.data.remote.responses.Stat
import com.erkindilekci.pokemonbook.data.remote.responses.Type
import com.erkindilekci.pokemonbook.presentation.ui.theme.AtkColor
import com.erkindilekci.pokemonbook.presentation.ui.theme.DefColor
import com.erkindilekci.pokemonbook.presentation.ui.theme.HPColor
import com.erkindilekci.pokemonbook.presentation.ui.theme.SpAtkColor
import com.erkindilekci.pokemonbook.presentation.ui.theme.SpDefColor
import com.erkindilekci.pokemonbook.presentation.ui.theme.SpdColor
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeBug
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeDark
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeDragon
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeElectric
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeFairy
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeFighting
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeFire
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeFlying
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeGhost
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeGrass
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeGround
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeIce
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeNormal
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypePoison
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypePsychic
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeRock
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeSteel
import com.erkindilekci.pokemonbook.presentation.ui.theme.TypeWater
import java.util.Locale

fun parseTypeToColor(type: Type): Color {
    return when (type.type.name.toLowerCase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: Stat): Color {
    return when (stat.stat.name.toLowerCase()) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: Stat): String {
    return when (stat.stat.name.toLowerCase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}
