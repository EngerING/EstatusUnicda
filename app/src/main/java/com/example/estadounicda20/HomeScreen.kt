package com.example.estadounicda20.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Task
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onVotacionClick: () -> Unit = {},
    onComentariosClick: () -> Unit = {},
    onTecnicoClick: () -> Unit = {},
    onEstadisticaClick: () -> Unit = {},
    onLogout: () -> Unit = {}
) {
    val colorCard = Color(0xFFF6F8FE)
    val colorPrimary = Color(0xFF4253E0)
    val colorIcon = Color(0xFF4253E0)
    val colorText = Color(0xFF212121)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        // Encabezado
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "¡Bienvenido, estudiante!",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = colorText
            )
            Surface(
                shape = CircleShape,
                color = colorCard,
                modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Avatar",
                    tint = colorPrimary,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))

        // Tarjetas principales
        FeatureCard(
            icon = Icons.Default.ThumbUp,
            title = "Votación",
            desc = "Votación sobre el estado de las aulas, baños y aire acondicionado.",
            colorIcon = colorIcon,
            colorCard = colorCard,
            onClick = onVotacionClick
        )
        FeatureCard(
            icon = Icons.Default.Comment,
            title = "Comentarios",
            desc = "Lea los comentarios públicos sobre las instalaciones de la universidad.",
            colorIcon = colorIcon,
            colorCard = colorCard,
            onClick = onComentariosClick
        )
        FeatureCard(
            icon = Icons.Default.Task,
            title = "Progreso del técnico",
            desc = "Tareas de mantenimiento y reparaciones actuales.",
            colorIcon = colorIcon,
            colorCard = colorCard,
            onClick = onTecnicoClick
        )
        FeatureCard(
            icon = Icons.Default.BarChart,
            title = "Estadística",
            desc = "Métricas de condición de la universidad.",
            colorIcon = colorIcon,
            colorCard = colorCard,
            onClick = onEstadisticaClick
        )

        Spacer(modifier = Modifier.weight(1f))
        // ***NO pongas aquí el BottomNavigationBar***
    }
}

@Composable
fun FeatureCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    desc: String,
    colorIcon: Color,
    colorCard: Color,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = colorCard)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(36.dp),
                shape = CircleShape,
                color = Color.White
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = colorIcon,
                    modifier = Modifier.padding(6.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, color = colorIcon)
                Text(desc, fontSize = 13.sp, color = Color.Gray)
            }
        }
    }
}
