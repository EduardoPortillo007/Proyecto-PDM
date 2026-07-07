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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.zeppedapp.R

data class MenuProduct(
    val name: String,
    val isCombo: Boolean,
    val price: Double,
    val emoji: String,
    val description: String
)

@Composable
fun PantallaVenta(
    backStack: NavBackStack<NavKey>,
    onBackClick: () -> Unit
){
    //Debe de tener:
    //Unos cuadros con el nombre y la imagen del platillo(Cheesy, Chilli) en individual y en combo
    // (ya te pasaré por wasap todo el menú con sus ingredientes y que sean clickeables
    //Botón de regresar
    val darkRed = Color(0xFF6B0000)
    val cardBgColor = Color(0xFFD68A8A).copy(alpha = 0.85f)
    val buttonBgColor = Color(0xFFE5B4B4)

    val quantities = remember {
        mutableStateListOf<Int>().apply {
            addAll(/*Lista*/)
        }
    }

    val totalAmount = menuList.mapIndexed { index, product -> product.price * quantities[index] }.sum()
    val totalItems = quantities.sum()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkRed),
        contentAlignment = Alignment.TopCenter
    ) {
        // Fondo decorativo de marca de agua (compatible con la estética de image_49a44d.png)
        Image(
            painter = painterResource(id = R.drawable.logo_fondo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(bottom = 60.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .padding(top = 40.dp, bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Tarjeta translúcida principal
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(40.dp),
                colors = CardDefaults.cardColors(containerColor = cardBgColor)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Cabecera de la sección
                    Text(text = "🛒", fontSize = 32.sp, modifier = Modifier.padding(bottom = 4.dp))
                    Text(
                        text = "Venta de Menú",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    HorizontalDivider(color = Color.Black.copy(alpha = 0.15f), thickness = 1.dp)
                    Spacer(modifier = Modifier.height(14.dp))

                    // Grid dinámico de 2 columnas para mostrar los cuadros simétricamente
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier.weight(1f),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        itemsIndexed(menuList) { index, product ->
                            ProductMenuCard(
                                product = product,
                                quantity = quantities[index],
                                onAdd = { quantities[index] += 1 },
                                onRemove = { if (quantities[index] > 0) quantities[index] -= 1 }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))
                    HorizontalDivider(color = Color.Black.copy(alpha = 0.15f), thickness = 1.dp)
                    Spacer(modifier = Modifier.height(10.dp))

                    // Barra resumen con el precio total acumulado
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "Total de artículos: $totalItems",
                                fontSize = 13.sp,
                                color = Color.Black.copy(alpha = 0.6f)
                            )
                            Text(
                                text = "Total a Pagar",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                        Text(
                            text = String.format("$%.2f", totalAmount),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFF6B0000)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Botón para concretar la transacción
                    Button(
                        onClick = { /* Lógica para procesar la venta */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(16.dp),
                        enabled = totalItems > 0
                    ) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Procesar Venta", fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Botón en forma de píldora para regresar, idéntico al de CurrentInventoryScreen (image_4a7eb9.png)
            Surface(
                modifier = Modifier
                    .width(180.dp)
                    .height(50.dp)
                    .clickable { onBackClick() },
                shape = CircleShape,
                color = cardBgColor
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Volver",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun ProductMenuCard(
    product: MenuProduct,
    quantity: Int,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    val cardHighlight = Color(0xFFE5B4B4)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Sección Visual: Emojis Grandes como representación gráfica
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(cardHighlight, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = product.emoji, fontSize = 24.sp)
            }

            // Nombre del platillo y tipo (Combo o Individual)
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = if (product.isCombo) "En Combo" else "Individual",
                    fontSize = 11.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
            }

            // Precio destacado
            Text(
                text = String.format("$%.2f", product.price),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color(0xFF6B0000)
            )

            // Control de cantidad intuitivo (Botones - / +)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.05f), shape = RoundedCornerShape(12.dp))
                    .padding(vertical = 2.dp, horizontal = 4.dp)
            ) {
                IconButton(
                    onClick = onRemove,
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "Disminuir",
                        tint = if (quantity > 0) Color.Black else Color.Gray.copy(alpha = 0.5f),
                        modifier = Modifier.size(16.dp)
                    )
                }

                Text(
                    text = "$quantity",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black
                )

                IconButton(
                    onClick = onAdd,
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Aumentar",
                        tint = Color.Black,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}
