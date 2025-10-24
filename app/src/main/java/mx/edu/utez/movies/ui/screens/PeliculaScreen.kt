package mx.edu.utez.movies.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import mx.edu.utez.movies.ui.components.PeliculaList
import mx.edu.utez.movies.ui.components.texts.Label
import mx.edu.utez.movies.ui.components.texts.Title
import mx.edu.utez.movies.viewmodel.PeliculaViewModel

@Composable
fun PeliculaScreen(viewModel: PeliculaViewModel, navController: NavController){
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(90.dp)
    ) {
        Title("Pasaportes registrados")
        val pelis by viewModel.movies.collectAsStateWithLifecycle()
        PeliculaList(pelis) { pelicula ->
            //viewModel.clickPassport(pelicula)
            //navController.navigate("stampas")
        }
        Label("No hay más Peliculas")
    }
}