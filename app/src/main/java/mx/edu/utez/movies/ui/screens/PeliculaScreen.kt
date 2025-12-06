package mx.edu.utez.movies.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import mx.edu.utez.movies.ui.components.PeliculaList
import mx.edu.utez.movies.ui.components.texts.Label
import mx.edu.utez.movies.ui.components.texts.Title
import mx.edu.utez.movies.viewmodel.PeliculaViewModel
import mx.edu.utez.movies.viewmodel.PeliculaViewModelFactory

@Composable
fun PeliculaScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val viewModel: PeliculaViewModel = viewModel(factory = PeliculaViewModelFactory(context))
    val pelis by viewModel.peliculas.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Title("Películas registradas")

        if (pelis.isNotEmpty()) {
            PeliculaList(
                lista = pelis,
                onClick = { pelicula ->
                    viewModel.clickPelicula(pelicula)
                    navController.navigate("modificar")
                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
        } else {
            Label("No hay películas registradas")
        }
    }
}
