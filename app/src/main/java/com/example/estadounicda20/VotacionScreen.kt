package com.example.estadounicda20.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class VotacionItemData(
    val nombre: String,
    val icono: ImageVector,
    var likes: Int = 0,
    var dislikes: Int = 0
)

@Composable
fun VotacionScreen(
    onNavigateBack: () -> Unit = {}
) {
    val bgCard = Color(0xFFF6F8FE)
    val colorLike = Color(0xFF32D5B8)
    val colorDislike = Color(0xFFFF4D5A)

    // Simulación de items (puedes adaptarlo a tu modelo real)
    var items by remember {
        mutableStateOf(
            listOf(
                VotacionItemData("Aulas", Icons.Default.School),
                VotacionItemData("Baños", Icons.Default.Wc),
                VotacionItemData("Aire acondicionado", Icons.Default.Air),
                VotacionItemData("Pasillos", Icons.Default.DirectionsWalk)
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp)
    ) {
        Button(
            onClick = { onNavigateBack() },
            modifier = Modifier.align(Alignment.Start)
        ) { Text("Volver") }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = CardDefaults.cardColors(containerColor = bgCard)
        ) {
            Text(
                "Votación sobre las instalaciones del campus.",
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .align(Alignment.CenterHorizontally),
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = Color.Black
            )
        }

        Spacer(Modifier.height(10.dp))

        items.forEachIndexed { idx, item ->
            VotacionItemAnimada(
                nombre = item.nombre,
                icono = item.icono,
                likes = item.likes,
                dislikes = item.dislikes,
                colorLike = colorLike,
                colorDislike = colorDislike,
                bgCard = bgCard,
                onLike = {
                    val newItems = items.toMutableList()
                    newItems[idx] = newItems[idx].copy(likes = item.likes + 1)
                    items = newItems
                },
                onDislike = {
                    val newItems = items.toMutableList()
                    newItems[idx] = newItems[idx].copy(dislikes = item.dislikes + 1)
                    items = newItems
                }
            )
        }
    }
}

@Composable
fun VotacionItemAnimada(
    nombre: String,
    icono: ImageVector,
    likes: Int,
    dislikes: Int,
    colorLike: Color,
    colorDislike: Color,
    bgCard: Color,
    onLike: () -> Unit,
    onDislike: () -> Unit
) {
    val total = likes + dislikes
    val progress = if (total == 0) 0f else likes / total.toFloat()
    val animatedProgress by animateFloatAsState(targetValue = progress, label = "")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = bgCard)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icono,
                contentDescription = nombre,
                tint = Color(0xFF4253E0),
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = nombre,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212121),
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                // Barra de progreso animada
                LinearProgressIndicator(
                    progress = animatedProgress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .background(Color(0xFFE5E7EB), RoundedCornerShape(4.dp)),
                    color = colorLike,
                    trackColor = Color(0xFFE5E7EB)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                ChipVoto(cantidad = likes, color = colorLike, onClick = onLike)
                Spacer(modifier = Modifier.height(3.dp))
                ChipVoto(cantidad = dislikes, color = colorDislike, onClick = onDislike)
            }
        }
    }
}

@Composable
fun ChipVoto(cantidad: Int, color: Color, onClick: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(40.dp),
        color = color,
        shadowElevation = 2.dp,
        modifier = Modifier.clickable { onClick() }
    ) {
        Text(
            text = cantidad.toString(),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )
    }
}
