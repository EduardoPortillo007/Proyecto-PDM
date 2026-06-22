package com.example.zeppedapp.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.zeppedapp.R

@Composable
fun PantallaPrincipal(
    backStack: NavBackStack<NavKey>
){
    val rojoFondo = Color(0xFF6B0000)
    val colorContenedorOopaco = Color(0xDDFAC0C0) // Color rosado/claro con transparencia (alfa DD)
    val colorIconoFondo = Color(0xFFFAC0C0)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(rojoFondo),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo_fondo),
            contentDescription = "Silueta principal",
            modifier = Modifier.fillMaxSize(0.8f),
            contentScale = ContentScale.Fit
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Botón de Configuración (Tuerca arriba a la izquierda)
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopStart) {
                IconButton(onClick = { /* Acción ajustar */ }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Configuración",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Fila de Botones: Actualizar y Añadir Inventario
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement =  androidx.compose.foundation.layout.Arrangement.SpaceEvenly
            ) {
                BotonMenuCircular(icon = Icons.Default.Edit, label = "Actualizar Inventario", containerColor = colorIconoFondo)
                BotonMenuCircular(icon = Icons.Default.Add, label = "Añadir Inventario", containerColor = colorIconoFondo)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón central: Ver Inventario
            BotonMenuCircular(icon = Icons.Default.List, label = "Ver Inventario", containerColor = colorIconoFondo)

            Spacer(modifier = Modifier.weight(1f)) // Empuja la tarjeta de notificaciones hacia abajo

            // 3. Tarjeta de Notificaciones
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp),
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(containerColor = colorContenedorOopaco)
            ) {
                Box(modifier = Modifier.fillMaxSize().padding(20.dp)) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Notificaciones:",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF331111)
                        )
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 12.dp),
                            color = Color(0x33331111)
                        )

                        // Lista de notificaciones ficticias
                        ItemNotificacion("• 89 Panes añadidos")
                        ItemNotificacion("• Mínimo de \"Queso\" alcanzado")
                        ItemNotificacion("• Inventario actualizado")
                    }

                    // Botón de Basurero abajo a la derecha
                    IconButton(
                        onClick = { /* Borrar notificaciones */ },
                        modifier = Modifier.align(Alignment.BottomEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Borrar",
                            tint = Color(0xFF331111),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
            }
        }

    }
}

@Composable
fun BotonMenuCircular(icon: ImageVector, label: String, containerColor: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(130.dp)
    ) {
        IconButton(
            onClick = { /* Acción */ },
            modifier = Modifier
                .size(75.dp)
                .background(containerColor, shape = CircleShape)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color(0xFF442222), // Tono oscuro para las líneas del icono
                modifier = Modifier.size(36.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            fontSize = 13.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun ItemNotificacion(texto: String) {
    Text(
        text = texto,
        fontSize = 14.sp,
        color = Color(0xFF442222),
        modifier = Modifier.padding(vertical = 4.dp)
    )
}