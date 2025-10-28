package mx.edu.utez.movies.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import mx.edu.utez.movies.ui.components.PeliculaList
import mx.edu.utez.movies.ui.components.texts.Label
import mx.edu.utez.movies.ui.components.texts.Title
import mx.edu.utez.movies.viewmodel.PeliculaViewModel

@Composable
fun PeliculaScreen(viewModel: PeliculaViewModel, navController: NavController) {
    val pelis by viewModel.peliculas.collectAsStateWithLifecycle() // usa el nombre correcto

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // espacio alrededor
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Title("Películas registradas")

        if (pelis.isNotEmpty()) {
            PeliculaList(pelis) { pelicula ->
                viewModel.clickPelicula(pelicula)
                navController.navigate("modificar")
            }
        } else {
            Label("No hay películas registradas")
        }
    }
}
