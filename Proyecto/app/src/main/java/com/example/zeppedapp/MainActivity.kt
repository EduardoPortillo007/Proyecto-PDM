package com.example.zeppedapp

import android.R.attr.color
import android.R.attr.src
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.zeppedapp.ui.theme.Screens.Login
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    appNav()
}

@Composable
fun appNav(){
    val nav = rememberNavController()

    NavHost(
        navController = nav,
        startDestination = "home"
    ){
        composable("home"){
            singInSreen(nav)
        }
        composable("Main"){
            mainScreen(nav)
        }
        composable("add"){
            addScreen(nav)
        }
        composable("update"){
            updateScreen(nav)
        }
        composable("inventory"){
            inventoryScreen(nav)
        }
    }
}

@Composable
fun singInSreen(navController: NavController){
    var password by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF4C0101))
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo para la aplicacion",
            modifier = Modifier.size(270.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text("Iniciar sesion", color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            state = rememberTextFieldState(),
            label = { Text("Usuario") },
            shape = RoundedCornerShape(12.dp),

            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,

                focusedPlaceholderColor = Color.Black,
                unfocusedPlaceholderColor = Color.Black,

                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,

                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(

            value = password,

            onValueChange = {
                password = it
            },

            label = {
                Text("Contraseña")
            },

            visualTransformation =
                if (visible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),

            trailingIcon = {

                IconButton(
                    onClick = {
                        visible = !visible
                    }
                ) {

                    Icon(
                        imageVector =
                            if (visible)
                                Icons.Default.Visibility
                            else
                                Icons.Default.VisibilityOff,

                        contentDescription = "Mostrar contraseña"
                    )
                }
            },

            shape = RoundedCornerShape(12.dp),

            colors = OutlinedTextFieldDefaults.colors(

                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,

                focusedPlaceholderColor = Color.Black,
                unfocusedPlaceholderColor = Color.Black,

                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,

                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),

            shape = RoundedCornerShape(12.dp),

            modifier = Modifier
                .width(280.dp)
                .height(55.dp),

            onClick = {
                navController.navigate("Main")
            }
        ) {
            Text("Iniciar Sesion", color = Color.White)
        }
        Spacer(modifier = Modifier.height(500.dp))
    }
}

@Composable
fun mainScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF4C0101))
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

    }
}




@Composable
fun addScreen(navController: NavController){

}

@Composable
fun updateScreen(navController: NavController){

}

@Composable
fun inventoryScreen(navController: NavController){

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ZeppedAppTheme {
        Greeting()
    }
}