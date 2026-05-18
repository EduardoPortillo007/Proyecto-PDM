package com.example.zeppedapp.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Screens : NavKey {

    @Serializable
    data object Login: Screens(){

    }

    @Serializable
    data object Principal : Screens(){

    }

    @Serializable
    data object Actualizar : Screens(){

    }

    @Serializable
    data object UpdatearInv : Screens(){

    }

    @Serializable
    data object VerInventario : Screens(){

    }


}