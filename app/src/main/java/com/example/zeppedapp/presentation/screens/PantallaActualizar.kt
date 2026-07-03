package com.example.zeppedapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.zeppedapp.R



@Composable
fun PantallaActualizar(
    backStack: NavBackStack<NavKey>
) {
    val rojoFondo = Color(0xFF4C0101)
    val cardBgColor = Color(0xFFD68A8A).copy(alpha = 0.85f)

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

        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 48.dp),
            shape = RoundedCornerShape(40.dp),
            colors = CardDefaults.cardColors(containerColor = cardBgColor)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Icono e Identificador de Pantalla
                Text(text = "🌭", fontSize = 32.sp, modifier = Modifier.padding(bottom = 4.dp))

                Text(
                    text = "Actualizar Inventario", // <- Título actualizado según image_4b6eda.png
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))
                HorizontalDivider(color = Color.Black.copy(alpha = 0.2f), thickness = 1.dp)
                Spacer(modifier = Modifier.height(16.dp))

                // ---- CAMPOS DE TEXTO ----
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("Tipo de Producto") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    trailingIcon = { Icon(Icons.Default.ArrowDropDown, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("Cantidad") },
                    leadingIcon = { Icon(Icons.Default.Edit, contentDescription = null) },
                    trailingIcon = {
                        Icon(
                            Icons.Default.Clear,
                            contentDescription = "Limpiar campo"
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Subtítulo de Acciones
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
                    Text(text = "Acciones", fontSize = 12.sp, color = Color.Gray)
                }
                Spacer(modifier = Modifier.height(8.dp))

                // ---- FILAS DE ACCIÓN MODIFICADAS ----
                UpdateActionRow(
                    icon = Icons.Default.Refresh,
                    title = "Guardados recientemente",
                    hasArrow = true
                )
                UpdateActionRow(
                    icon = Icons.Default.Menu,
                    title = "Tabla de Productos",
                    hasArrow = true
                )
                UpdateActionRow(
                    icon = Icons.Default.Delete,
                    title = "Limpiar",
                    textColor = Color.Red
                )
                // Se ha removido la fila de "Guardar" según el diseño actual

                Spacer(modifier = Modifier.weight(1f))

                // ---- BOTÓN REGRESAR ----
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* Regresar */ }
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Regresar")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Regresar", fontSize = 16.sp)
                }
            }
        }
    }
}

    @Composable
    fun UpdateActionRow(
        icon: ImageVector,
        title: String,
        textColor: Color = Color.Black,
        hasArrow: Boolean = false
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Click */ }
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = title, tint = if(textColor == Color.Red) Color.Red else Color.Black)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = title, fontSize = 16.sp, color = textColor, modifier = Modifier.weight(1f))
            if (hasArrow) {
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }
    }


