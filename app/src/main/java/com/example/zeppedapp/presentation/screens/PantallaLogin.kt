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
import com.example.zeppedapp.R

@Composable
fun PantallaLogin(
    backStack: NavBackStack<NavKey>
){

    var usuario by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }


    var usuarioError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

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
            value = usuario,
            onValueChange = {
                usuario = it
                if (it.isNotBlank()) usuarioError = false // Quita el error si escribe
            },
            label = { Text(if (usuarioError) "El usuario es obligatorio" else "Usuario") },
            isError = usuarioError, // Activa el estado visual de error si es true
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = if (usuarioError) Color.Red else Color.Black,
                unfocusedBorderColor = if (usuarioError) Color.Red else Color.Black,
                errorLabelColor = Color.Yellow, // Color del texto de error personalizado
                errorContainerColor = Color.White
            )
        )
        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                if (it.isNotBlank()) passwordError = false // Quita el error si escribe
            },
            label = { Text(if (passwordError) "La contraseña es obligatoria" else "Contraseña") },
            isError = passwordError, // Activa el estado visual de error si es true
            visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { visible = !visible }) {
                    Icon(
                        imageVector = if (visible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Mostrar contraseña"
                    )
                }
            },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = if (passwordError) Color.Red else Color.Black,
                unfocusedBorderColor = if (passwordError) Color.Red else Color.Black,
                errorLabelColor = Color.Yellow,
                errorContainerColor = Color.White
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
                // Validación quitando espacios vacíos (.trim())
                val isUsuarioVacio = usuario.trim().isEmpty()
                val isPasswordVacio = password.trim().isEmpty()

                // Asignamos el resultado a los estados de error
                usuarioError = isUsuarioVacio
                passwordError = isPasswordVacio

                if (!isUsuarioVacio && !isPasswordVacio) {

                }
            }
        ) {
            Text("Iniciar Sesion", color = Color.Black)
        }
        Spacer(modifier = Modifier.height(500.dp))
    }
}