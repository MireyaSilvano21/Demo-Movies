package mx.edu.utez.movies.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import mx.edu.utez.movies.viewmodel.PeliculaViewModel

@Composable
fun ModificarPelicula(
    navController: NavController,
    viewModel: PeliculaViewModel = viewModel()
) {
    val pelicula by viewModel.selectedPelicula.collectAsState()
    var titulo by remember { mutableStateOf(pelicula?.titulo ?: "") }
    var genero by remember { mutableStateOf(pelicula?.genero ?: "") }
    var year by remember { mutableStateOf(pelicula?.year?.toString() ?: "") }
    var sinopsis by remember { mutableStateOf(pelicula?.sinopsis ?: "") }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (pelicula != null) {
            Text(
                "Modificar Película: ${pelicula?.titulo}",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = titulo,
                onValueChange = { titulo = it },
                label = { Text("Título") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = genero,
                onValueChange = { genero = it },
                label = { Text("Género") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = year,
                onValueChange = { year = it },
                label = { Text("Año") },
                singleLine = true
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = sinopsis,
                onValueChange = { sinopsis = it },
                label = { Text("Sinopsis") },
                modifier = Modifier.height(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                viewModel.actualizarPelicula(
                    titulo = titulo,
                    genero = genero,
                    year = year.toIntOrNull() ?: pelicula!!.year,
                    sinopsis = sinopsis
                )
                navController.popBackStack()
            }) {
                Text("Guardar cambios")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text("Cancelar")
            }
        } else {
            Text("No hay película seleccionada")
        }
    }
}
