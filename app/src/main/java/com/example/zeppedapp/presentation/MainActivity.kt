package com.example.zeppedapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.zeppedapp.presentation.navigation.Screens
import com.example.zeppedapp.presentation.screens.PantallaInventario
import com.example.zeppedapp.presentation.screens.PantallaLogin
import com.example.zeppedapp.presentation.screens.PantallaPrincipal
import com.example.zeppedapp.presentation.screens.PantallaProductoMenu
import com.example.zeppedapp.presentation.screens.PantallaVenta
import com.example.zeppedapp.ui.theme.ZeppedAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZeppedAppTheme {
                val backStack = rememberNavBackStack(Screens.Login)

                NavDisplay(
                    backStack = backStack,
                    entryProvider = entryProvider {
                        entry<Screens.Login> {
                            PantallaLogin(
                                backStack = backStack
                            )
                        }
                        entry<Screens.Principal> {
                            PantallaPrincipal(
                                backStack = backStack
                            )
                        }
                        entry<Screens.Venta> {
                            PantallaVenta(
                                backStack = backStack,
                            )
                        }
                        entry<Screens.Inventario> {
                            PantallaInventario(
                                backStack = backStack
                            )
                        }
                        entry<Screens.ProductoMenu> {
                            PantallaProductoMenu(
                                backStack = backStack
                            )
                        }
                    }
                )
            }
        }
    }
}