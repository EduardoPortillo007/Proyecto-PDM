package com.example.zeppedapp.navegation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Screens : NavKey {

    @Serializable
    data object Principal : Screens()

    @Serializable
    data object  Home : Screens()

}