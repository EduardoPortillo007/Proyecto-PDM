package com.example.zeppedapp.presentation.screens

//Pantalla para ordena, debe de tener:
// + y - de la cantidad de platos que quiereel cliente,
// check para todos los ingrdientes del platillo(por ejemplo tomate, salsa etc consu check box)
// y luego un botón de confirmar o cancelar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.zeppedapp.R

// Estructura de datos interna para manejar los ingredientes opcionales
data class CustomIngredient(
    val name: String,
    val isIncluded: Boolean
)

@Composable
fun PantallaProductoMenu(
    backStack: NavBackStack<NavKey>,
    productName: String = "Cheesy Hot Dog",
    productEmoji: String = "🌭🧀",
    onConfirmClick: (quantity: Int, ingredients: List<String>) -> Unit = { _, _ -> },
    onCancelClick: () -> Unit = {}
) {
    val darkRed = Color(0xFF6B0000)
    val cardBgColor = Color(0xFFD68A8A).copy(alpha = 0.85f)
    val buttonBgColor = Color(0xFFE5B4B4)

    // 1. CONTROL DE ESTADO DE LA CANTIDAD (+ y -)
    var quantity by remember { mutableStateOf(1) }

    // 2. CHECK PARA TODOS LOS INGREDIENTES CON SU CHECKBOX
    val ingredientsList = remember {
        mutableStateListOf(
            CustomIngredient("Salchicha Especial", true),
            CustomIngredient("Queso Fundido", true),
            CustomIngredient("Tomate Picado", true),
            CustomIngredient("Cebolla Caramelizada", true),
            CustomIngredient("Salsa Ketchup", true),
            CustomIngredient("Mayonesa Casera", true),
            CustomIngredient("Papas Fritas de acompañamiento", false)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(darkRed),
        contentAlignment = Alignment.TopCenter
    ) {
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
                .padding(horizontal = 24.dp)
                .padding(top = 40.dp, bottom = 24.dp),
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
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Platillo seleccionado
                    Text(text = productEmoji, fontSize = 36.sp, modifier = Modifier.padding(bottom = 4.dp))
                    Text(
                        text = "Personalizar Orden",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = productName,
                        fontSize = 15.sp,
                        color = Color.Black.copy(alpha = 0.6f),
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    HorizontalDivider(color = Color.Black.copy(alpha = 0.15f), thickness = 1.dp)
                    Spacer(modifier = Modifier.height(16.dp))

                    // Selector interactivo de cantidades (+ y -)
                    Text(
                        text = "Cantidad de Platos",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White.copy(alpha = 0.6f), shape = RoundedCornerShape(16.dp))
                            .padding(vertical = 8.dp, horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { if (quantity > 1) quantity-- },
                            modifier = Modifier
                                .background(Color.Black.copy(alpha = 0.1f), CircleShape)
                                .size(36.dp)
                        ) {
                            Icon(Icons.Default.Remove, contentDescription = "Disminuir", tint = Color.Black)
                        }

                        Text(
                            text = "$quantity",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.Black
                        )

                        IconButton(
                            onClick = { quantity++ },
                            modifier = Modifier
                                .background(Color.Black.copy(alpha = 0.1f), CircleShape)
                                .size(36.dp)
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Aumentar", tint = Color.Black)
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    //Lista scrolleable de ingredientes con Checkbox
                    Text(
                        text = "Ingredientes del Platillo",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.White.copy(alpha = 0.6f), shape = RoundedCornerShape(20.dp))
                            .padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        itemsIndexed(ingredientsList) { index, ingredient ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        ingredientsList[index] = ingredient.copy(isIncluded = !ingredient.isIncluded)
                                    }
                                    .padding(vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = ingredient.name,
                                    fontSize = 15.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Medium
                                )
                                Checkbox(
                                    checked = ingredient.isIncluded,
                                    onCheckedChange = { isChecked ->
                                        ingredientsList[index] = ingredient.copy(isIncluded = isChecked)
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = Color(0xFF6B0000),
                                        uncheckedColor = Color.Black.copy(alpha = 0.4f)
                                    )
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    // Zona de confirmacion
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // Cancelar
                        OutlinedButton(
                            onClick = { onCancelClick() },
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                            border = ButtonDefaults.outlinedButtonBorder.copy(
                                brush = androidx.compose.ui.graphics.SolidColor(Color.Black.copy(alpha = 0.4f))
                            )
                        ) {
                            Icon(Icons.Default.Close, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Cancelar", fontWeight = FontWeight.Bold)
                        }

                        // Boton de confirmacion
                        Button(
                            onClick = {
                                val finalizedIngredients = ingredientsList
                                    .filter { it.isIncluded }
                                    .map { it.name }
                                onConfirmClick(quantity, finalizedIngredients)
                            },
                            modifier = Modifier
                                .weight(1.3f)
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black,
                                contentColor = Color.White
                            )
                        ) {
                            Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Confirmar", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón  de regresar independiente en la parte inferior
            Surface(
                modifier = Modifier
                    .width(180.dp)
                    .height(52.dp)
                    .clickable { onCancelClick() },
                shape = CircleShape,
                color = cardBgColor
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Regresar",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Regresar",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                }
            }
        }
    }
}