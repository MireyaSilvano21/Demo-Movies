package mx.edu.utez.movies.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.movies.ui.screens.AñadirScreen
import mx.edu.utez.movies.ui.screens.EliminarPelicula
import mx.edu.utez.movies.ui.screens.LoginScreen
import mx.edu.utez.movies.ui.screens.MainScreen
import mx.edu.utez.movies.ui.screens.ModificarPelicula
import mx.edu.utez.movies.ui.screens.OlvidarContraScreen
import mx.edu.utez.movies.ui.screens.PeliculaScreen
import mx.edu.utez.movies.ui.screens.RegistroScreen
import mx.edu.utez.movies.viewmodel.AñadirViewModel
import mx.edu.utez.movies.viewmodel.AñadirViewModelFactory
import mx.edu.utez.movies.viewmodel.LoginViewModel
import mx.edu.utez.movies.viewmodel.MainViewModel
import mx.edu.utez.movies.viewmodel.OlvidarContraViewModel
import mx.edu.utez.movies.viewmodel.PeliculaViewModel
import mx.edu.utez.movies.viewmodel.PeliculaViewModelFactory
import mx.edu.utez.movies.viewmodel.RegistroViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            val viewModel: LoginViewModel = viewModel()
            LoginScreen(viewModel = viewModel, navController = navController)
        }

        composable("forgot_password") {
            val viewModel: OlvidarContraViewModel = viewModel()
            OlvidarContraScreen(viewModel = viewModel, navController = navController)
        }

        composable("register") {
            val viewModel: RegistroViewModel = viewModel()
            RegistroScreen(viewModel = viewModel, navController = navController)
        }

        // 🔥 Películas — ViewModel lo crea la pantalla
        composable("pelis") {
            PeliculaScreen(navController = navController)
        }

        composable("main") {
            val viewModel: MainViewModel = viewModel()
            MainScreen(viewModel = viewModel, navController = navController)
        }

        // 🔥 Eliminar usa mismo ViewModel de Película
        composable("eliminar") {
            val viewModel: PeliculaViewModel =
                viewModel(factory = PeliculaViewModelFactory(context))
            EliminarPelicula(navController = navController, viewModel = viewModel)
        }

        // ❗ Si "modificar" usa Room USA este ViewModel, no ModificarViewModel
        composable("modificar") {
            val viewModel: PeliculaViewModel =
                viewModel(factory = PeliculaViewModelFactory(context))
            ModificarPelicula(navController = navController, viewModel = viewModel)
        }

        // 🔥 Añadir película
        composable("añadir") {
            val viewModel: AñadirViewModel =
                viewModel(factory = AñadirViewModelFactory(context))
            AñadirScreen(viewModel = viewModel, navController = navController)
        }
    }
}
