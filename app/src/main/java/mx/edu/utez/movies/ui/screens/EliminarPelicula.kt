package mx.edu.utez.movies.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import mx.edu.utez.movies.ui.components.buttons.PrimaryButton
import mx.edu.utez.movies.viewmodel.PeliculaViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EliminarPelicula(
    navController: NavController,
    viewModel: PeliculaViewModel = viewModel()
) {
    val pelicula by viewModel.selectedPelicula.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Pantalla de Eliminar Pelicula")

        Spacer(modifier = Modifier.height(16.dp))

        if (pelicula != null) {
            Text("¿Seguro que deseas eliminarla '${pelicula?.titulo}'?")
            Spacer(modifier = Modifier.height(16.dp))
            PrimaryButton(text = "Eliminar") {
                viewModel.eliminarPelicula()
                navController.popBackStack()
            }
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryButton(text = "Cancelar") {
                navController.popBackStack()
            }
        } else {
            Text("No hay película seleccionadas")
        }
    }
}
