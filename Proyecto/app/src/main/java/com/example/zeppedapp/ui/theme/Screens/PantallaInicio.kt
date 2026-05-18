package com.example.zeppedapp.ui.theme.Screens
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.zeppedapp.navegation.Screens

@Composable
fun Login(
    backStack: NavBackStack<NavKey>){


    Box(Modifier.fillMaxSize().padding(50.dp)){
        Text(text = "Hola Papuuuu")
        Button(
            onClick = {backStack.add(Screens.Home)},
            modifier = Modifier.align(Alignment.BottomCenter)) {

            Text("Hola Pipi")
        }
    }

}