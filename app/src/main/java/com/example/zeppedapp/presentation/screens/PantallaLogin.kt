package com.example.zeppedapp.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import com.example.zeppedapp.R

@Composable
fun PantallaLogin(
    backStack: NavBackStack<NavKey>
){
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
            painter = painterResource(R.drawable.logo_blanco),
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
                containerColor = Color(0xF2FFE8BF),
                contentColor = Color.White
            ),

            shape = RoundedCornerShape(12.dp),

            modifier = Modifier
                .width(280.dp)
                .height(55.dp),

            onClick = {

            }
        ) {
            Text("Iniciar Sesion", color = Color.Black)
        }
        Spacer(modifier = Modifier.height(500.dp))
    }
}