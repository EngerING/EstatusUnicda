package com.example.estadounicda20.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = BlueUnicda,
    onPrimary = Color.White,
    secondary = GreenUnicda,
    background = FondoClaro,
    onBackground = BlueUnicda
)

@Composable
fun EstadoUnicda20Theme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}
