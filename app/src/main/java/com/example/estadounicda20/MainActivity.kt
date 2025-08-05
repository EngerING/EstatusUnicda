package com.example.estadounicda20
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.estadounicda20.ui.theme.EstadoUnicda20Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EstadoUnicda20Theme {
                AppNavigation() // <-- SOLO esto, NO LoginScreen directo
            }
        }
    }
}
