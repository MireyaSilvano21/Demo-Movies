package mx.edu.utez.movies.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.movies.ui.screens.LoginScreen
import mx.edu.utez.movies.ui.screens.OlvidarContraScreen
import mx.edu.utez.movies.ui.screens.RegistroScreen
import mx.edu.utez.movies.viewmodel.LoginViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: LoginViewModel = viewModel() // instancia del ViewModel
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        composable("forgot_password") { OlvidarContraScreen(navController) }
        composable("register") { RegistroScreen(navController) }
    }
}