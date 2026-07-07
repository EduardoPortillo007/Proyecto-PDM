package com.example.zeppedapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import com.example.zeppedapp.R

@Composable
fun PantallaPrincipal(
    backStack: NavBackStack<NavKey>
){
    val darkRed = Color(0xFF6B0000)
    val cardBgColor = Color(0xFFD68A8A).copy(alpha = 0.85f)
    val buttonBgColor = Color(0xFFE5B4B4)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkRed),
        contentAlignment = Alignment.TopCenter
    ) {
        // Fondo con marca de agua (image_49a44d.png)
        Image(
            painter = painterResource(id = R.drawable.logo_fondo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(bottom = 80.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // ---- BARRA SUPERIOR (Ajustes) ----
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(onClick = { /* Abrir Ajustes */ }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Ajustes",
                        tint = Color.White,
                        modifier = Modifier.size(36.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ---- CUADRÍCULA DE BOTONES (2x2) ----
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MenuRoundButton(
                    title = "Actualizar Inventario",
                    icon = Icons.Default.Edit,
                    backgroundColor = buttonBgColor,
                    onClick = { /* Ir a Actualizar */ }
                )
                MenuRoundButton(
                    title = "Añadir Inventario",
                    icon = Icons.Default.Add,
                    backgroundColor = buttonBgColor,
                    onClick = { /* Ir a Añadir */ }
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MenuRoundButton(
                    title = "Ver Inventario",
                    icon = Icons.Default.Menu,
                    backgroundColor = buttonBgColor,
                    onClick = { /* Ir a Ver Inventario */ }
                )
                MenuRoundButton(
                    title = "Venta",
                    icon = Icons.Default.ShoppingCart,
                    backgroundColor = buttonBgColor,
                    onClick = { /* Ir a realizar una Venta */ }
                )
            }

            Spacer(modifier = Modifier.height(36.dp))

            // ---- SECCIÓN DE NOTIFICACIONES ----
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp,
                    bottomStart = 40.dp,
                    bottomEnd = 40.dp
                ),
                colors = CardDefaults.cardColors(containerColor = cardBgColor)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = "Notificaciones:",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        HorizontalDivider(color = Color.Black.copy(alpha = 0.15f), thickness = 1.dp)
                        Spacer(modifier = Modifier.height(16.dp))

                        // Aquí puedes añadir tus viñetas de notificaciones usando NotificationBulletPoint
                        NotificationBulletPoint(text = "89 Panes añadidos")
                        NotificationBulletPoint(text = "Mínimo de \"Queso\" alcanzado")
                        NotificationBulletPoint(text = "Inventario actualizado")
                    }

                    // EL BOTÓN SE MOVIÓ FUERA DE LA COLUMNA PERO SE MANTIENE DENTRO DEL BOX
                    // Ahora compila correctamente porque BoxScope provee el modificador align(Alignment.BottomEnd)
                    IconButton(
                        onClick = { /* Limpiar notificaciones */ },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Limpiar Notificaciones",
                            tint = Color.Black.copy(alpha = 0.8f),
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MenuRoundButton(
    title: String,
    icon: ImageVector,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(130.dp)
            .clickable { onClick() }
    ) {
        Surface(
            modifier = Modifier.size(80.dp),
            shape = CircleShape,
            color = backgroundColor,
            shadowElevation = 4.dp
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = Color.Black.copy(alpha = 0.7f),
                    modifier = Modifier.size(40.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            lineHeight = 16.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun NotificationBulletPoint(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "•  $text",
            fontSize = 15.sp,
            color = Color.Black.copy(alpha = 0.9f)
        )
    }
}