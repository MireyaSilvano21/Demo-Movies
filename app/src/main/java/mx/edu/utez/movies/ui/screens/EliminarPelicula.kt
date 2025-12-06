package mx.edu.utez.movies.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import mx.edu.utez.movies.ui.components.buttons.PrimaryButton
import mx.edu.utez.movies.viewmodel.PeliculaViewModel
import mx.edu.utez.movies.viewmodel.PeliculaViewModelFactory

@Composable
fun EliminarPelicula(
    navController: NavController
) {
    val context = LocalContext.current
    val viewModel: PeliculaViewModel = viewModel(factory = PeliculaViewModelFactory(context))

    val pelicula by viewModel.selectedPelicula.collectAsStateWithLifecycle()

    // Si no hay película seleccionada → regresa
    if (pelicula == null) {
        navController.popBackStack()
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Eliminar película")

        Spacer(modifier = Modifier.height(16.dp))

        Text("¿Seguro que deseas eliminar '${pelicula!!.titulo}'?")

        Spacer(modifier = Modifier.height(24.dp))

        PrimaryButton(text = "Eliminar") {
            viewModel.eliminarPelicula()
            navController.popBackStack()
        }

        Spacer(modifier = Modifier.height(12.dp))

        PrimaryButton(text = "Cancelar") {
            navController.popBackStack()
        }
    }
}
