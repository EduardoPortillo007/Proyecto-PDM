package com.example.zeppedapp.presentation.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Screens : NavKey {

    //Pantallas
    @Serializable
    data object Login: Screens(){

    }

    @Serializable
    data object Principal : Screens(){

    }

    @Serializable
    data object Venta : Screens(){

    }

    @Serializable
    data object Inventario : Screens(){

    }

    @Serializable
    data object ProductoMenu : Screens(){

    }


}