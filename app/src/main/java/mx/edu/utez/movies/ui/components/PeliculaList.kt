package mx.edu.utez.movies.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.edu.utez.movies.R
import mx.edu.utez.movies.data.model.Pelicula
import mx.edu.utez.movies.ui.Navigation
import mx.edu.utez.movies.ui.theme.MoviesTheme

@Composable
fun PeliculaList(lista: List<Pelicula>, x: (Pelicula) -> Unit, ) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = lista, key = {it.id} ) {pelicula ->
            PeliculaCard(pelicula,x,)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPeliculaList(){
    val lista = listOf(
        Pelicula(
            id = 1,
            titulo = "Harry Potter y la Piedra Filosofal",
            genero = "Fantasía/Aventura",
            year = 2001,
            sinopsis = "Harry Potter, un niño huérfano que vive con sus tíos, descubre al cumplir 11 años que es un mago y es invitado a estudiar en el Colegio Hogwarts de Magia y Hechicería, donde descubre su pasado y se enfrenta a un peligroso misterio para proteger la Piedra Filosofal.",
            R.drawable.harrypotter

        )
    )


    MoviesTheme {
        PeliculaList (lista) { }
    }
}