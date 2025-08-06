package com.example.estadounicda20

import com.example.estadounicda20.ui.HomeScreen
import com.example.estadounicda20.ui.VotacionScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.estadounicda20.ui.RegisterScreen
import com.example.estadounicda20.ui.BottomNavigationBar


object Routes {
    const val LOGIN = "login"
    const val HOME = "home"
    const val REGISTER = "register"
    const val VOTACION = "votacion"

}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()


    val showBottomBarRoutes = listOf(Routes.HOME, Routes.VOTACION)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute in showBottomBarRoutes) {
                BottomNavigationBar(
                    colorPrimary = Color(0xFF4253E0),
                    onHomeClick = { navController.navigate(Routes.HOME) },
                    onVotacionClick = { navController.navigate(Routes.VOTACION) },
                    onLogout = { navController.navigate(Routes.LOGIN) }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.LOGIN,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.LOGIN) {
                LoginScreen(
                    viewModel = authViewModel,
                    onLoginSuccess = { navController.navigate(Routes.HOME) },
                    onRegisterClick = { navController.navigate(Routes.REGISTER) }
                )
            }
            composable(Routes.REGISTER) {
                RegisterScreen(
                    viewModel = authViewModel,
                    onRegisterSuccess = { navController.popBackStack(Routes.LOGIN, false) },
                    onNavigateBack = { navController.popBackStack() }
                )
            }
            composable(Routes.HOME) {
                HomeScreen(
                    onVotacionClick = { navController.navigate(Routes.VOTACION) }

                )
            }
            composable(Routes.VOTACION) {
                VotacionScreen(
                    onNavigateBack = { navController.popBackStack() }
                )
            }

        }
    }
}
