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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.zeppedapp.R

data class InventoryItem(val name: String, val quantity: String)
@Composable
fun PantallaInventario(
    backStack: NavBackStack<NavKey>
){
    //Debe de tener:
    // un cuadro con la lista de todos los ingrdients y consumibles
    // un botón que diga "Actualizar Inventario" (debes de crear esa pantalla)
    //otro botón para regresar a la pantalla Principal
    val colorCarta = Color(0xFFD68A8A).copy(alpha = 0.85f)
    val rojoFondo = Color(0xFF4C0101)
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
                .padding(horizontal = 24.dp)
                .padding(top = 48.dp, bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(40.dp),
                colors = CardDefaults.cardColors(containerColor = colorCarta)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Emoji de Hotdog
                    Text(text = "🌭", fontSize = 32.sp, modifier = Modifier.padding(bottom = 4.dp))

                    Text(
                        text = "Inventario Actual",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    HorizontalDivider(color = Color.Black.copy(alpha = 0.15f), thickness = 1.dp)
                    Spacer(modifier = Modifier.height(12.dp))

                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        val inventoryList = 0
                        items(inventoryList) { item ->
                            InventoryRow(item = item)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ---- BOTÓN INDEPENDIENTE "VOLVER" ----
            Surface(
                modifier = Modifier
                    .width(180.dp)
                    .height(54.dp)
                    .clickable { /* Acción de volver */ },
                shape = CircleShape,
                color = colorCarta
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver",
                        tint = Color.Black,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Volver",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                }
            }
        }
    }
}
@Composable
fun InventoryRow(item: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Nombre del producto con viñeta (bullet point)
        Text(
            text = "•  ${item.name}",
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier.weight(1.3f) // Asigna mayor porcentaje de espacio a la izquierda
        )

        // Línea divisoria vertical sutil entre texto y cantidad
        VerticalDivider(
            modifier = Modifier.height(20.dp).padding(horizontal = 8.dp),
            color = Color.Black.copy(alpha = 0.15f),
            thickness = 1.dp
        )

        // Cantidad alineada a la derecha
        Text(
            text = item.quantity,
            fontSize = 15.sp,
            color = Color.Black.copy(alpha = 0.8f),
            modifier = Modifier.weight(0.7f).wrapContentWidth(Alignment.End)
        )
    }
}