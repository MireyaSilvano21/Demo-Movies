package mx.edu.utez.movies.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.movies.data.model.Pelicula
import mx.edu.utez.movies.ui.screens.AñadirScreen
import mx.edu.utez.movies.ui.screens.EliminarPelicula
import mx.edu.utez.movies.ui.screens.LoginScreen
import mx.edu.utez.movies.ui.screens.MainScreen
import mx.edu.utez.movies.ui.screens.ModificarPelicula
import mx.edu.utez.movies.ui.screens.OlvidarContraScreen
import mx.edu.utez.movies.ui.screens.PeliculaScreen
import mx.edu.utez.movies.ui.screens.RegistroScreen
import mx.edu.utez.movies.viewmodel.AñadirViewModel
import mx.edu.utez.movies.viewmodel.LoginViewModel
import mx.edu.utez.movies.viewmodel.MainViewModel
import mx.edu.utez.movies.viewmodel.ModificarViewModel
import mx.edu.utez.movies.viewmodel.OlvidarContraViewModel
import mx.edu.utez.movies.viewmodel.PeliculaViewModel
import mx.edu.utez.movies.viewmodel.RegistroViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            val viewModel: LoginViewModel = viewModel() // instancia del ViewModel
            LoginScreen(viewModel = viewModel, navController = navController)
        }
        composable("forgot_password") {
            val viewModel: OlvidarContraViewModel = viewModel() // instancia del ViewModel
            OlvidarContraScreen( viewModel,navController)}
        composable("register") {
            val viewModel: RegistroViewModel = viewModel() // instancia del ViewModel
            RegistroScreen( viewModel,navController)
        }

        composable("pelis") {
            val viewModel: PeliculaViewModel = viewModel() // instancia del ViewModel
            PeliculaScreen(viewModel = viewModel, navController = navController)
        }
        composable("main") {
            val viewModel: MainViewModel = viewModel() // instancia del ViewModel
            MainScreen(viewModel = viewModel, navController = navController)
        }
        composable("eliminar"){
            val viewModel: PeliculaViewModel = viewModel()
            EliminarPelicula(navController = navController, viewModel = viewModel)
        }
        composable("modificar") {
            val viewModel: ModificarViewModel = viewModel()
            ModificarPelicula(navController = navController, viewModel = viewModel)
        }
        composable("añadir") {
            val viewModel: AñadirViewModel = viewModel() // instancia del ViewModel
            AñadirScreen(viewModel = viewModel, navController = navController)
        }
    }
}