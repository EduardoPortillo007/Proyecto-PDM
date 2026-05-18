package com.example.zeppedapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.zeppedapp.ui.theme.Screens.Login
import com.example.zeppedapp.ui.theme.ZeppedAppTheme
import com.example.zeppedapp.ui.theme.Screens.Home
import com.example.zeppedapp.navegation.Screens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZeppedAppTheme {
                val backStack = rememberNavBackStack(Screens.Principal)

                NavDisplay(
                    backStack =backStack,
                    entryProvider = entryProvider {
                        entry<Screens.Principal> {
                            Login(backStack)
                        }
                        entry<Screens.Home> {
                            Home(backStack)
                        }
                    }
                )
            }
        }
    }
}