package com.example.estadounicda20.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable
fun BottomNavigationBar(
    colorPrimary: Color,
    onHomeClick: () -> Unit = {},
    onVotacionClick: () -> Unit = {},
    onComentariosClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onLogout: () -> Unit = {}
) {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            selected = false,
            onClick = onHomeClick,
            icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = colorPrimary) }
        )
        NavigationBarItem(
            selected = false,
            onClick = onVotacionClick,
            icon = { Icon(Icons.Default.ThumbUp, contentDescription = "Votación", tint = colorPrimary) }
        )
        NavigationBarItem(
            selected = false,
            onClick = onComentariosClick,
            icon = { Icon(Icons.Default.Comment, contentDescription = "Comentarios", tint = colorPrimary) }
        )
        NavigationBarItem(
            selected = false,
            onClick = onProfileClick,
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil", tint = colorPrimary) }
        )
    }
}

