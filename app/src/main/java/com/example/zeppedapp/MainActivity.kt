package com.example.zeppedapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.zeppedapp.navigation.Screens
import com.example.zeppedapp.ui.theme.ZeppedAppTheme
import com.example.zeppedapp.ui.theme.screens.PantallaActualizar
import com.example.zeppedapp.ui.theme.screens.PantallaInventario
import com.example.zeppedapp.ui.theme.screens.PantallaLogin
import com.example.zeppedapp.ui.theme.screens.PantallaPrincipal
import com.example.zeppedapp.ui.theme.screens.PantallaUpdate

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
                        entry<Screens.Principal>{
                            PantallaPrincipal(
                                backStack = backStack
                            )
                        }
                        entry<Screens.Actualizar>{
                            PantallaActualizar(
                                backStack = backStack
                            )
                        }
                        entry<Screens.UpdatearInv>{
                            PantallaUpdate(
                                backStack = backStack
                            )
                        }
                        entry<Screens.VerInventario>{
                            PantallaInventario(
                                backStack = backStack
                            )
                        }
                    }
                )
            }
        }
    }
}
