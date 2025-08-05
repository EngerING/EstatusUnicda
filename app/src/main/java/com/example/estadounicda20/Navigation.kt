package com.example.estadounicda20

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.estadounicda20.ui.RegisterScreen

object Routes {
    const val LOGIN = "login"
    const val HOME = "home"
    const val REGISTER = "register"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()

    NavHost(navController = navController, startDestination = Routes.LOGIN) {
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
            HomeScreen()
        }
    }
}
