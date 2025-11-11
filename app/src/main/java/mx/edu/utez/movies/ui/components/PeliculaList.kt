package mx.edu.utez.movies.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.movies.R
import mx.edu.utez.movies.data.model.Pelicula
import mx.edu.utez.movies.ui.Navigation
import mx.edu.utez.movies.ui.theme.MoviesTheme
import mx.edu.utez.movies.viewmodel.PeliculaViewModel

@Composable
fun PeliculaList(lista: List<Pelicula>, onClick: (Pelicula) -> Unit,  modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 80.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = lista, key = { it.id }) { pelicula ->
            PeliculaCard(pelicula, onClick)
        }
    }
}

