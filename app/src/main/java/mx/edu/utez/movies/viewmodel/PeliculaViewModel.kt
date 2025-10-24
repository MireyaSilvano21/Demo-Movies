package mx.edu.utez.movies.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import mx.edu.utez.movies.R
import mx.edu.utez.movies.data.model.Pelicula

class PeliculaViewModel : ViewModel() {
    val _Peliculas = MutableStateFlow<List<Pelicula>>(emptyList())
    val movies: StateFlow<List<Pelicula>> = _Peliculas
    private val _selectedPelicula = MutableStateFlow<Pelicula?>(null)
    val selectedPassport: StateFlow<Pelicula?> = _selectedPelicula

    init {
        _Peliculas.value = listOf(
            Pelicula(

                id = 1,
                titulo = "Harry Potter y la Piedra Filosofal",
                genero = "Fantasía/Aventura",
                year = 2001,
                sinopsis = "Harry Potter, un niño huérfano que vive con sus tíos, descubre al cumplir 11 años que es un mago y es invitado a estudiar en el Colegio Hogwarts de Magia y Hechicería, donde descubre su pasado y se enfrenta a un peligroso misterio para proteger la Piedra Filosofal.",
                R.drawable.harrypotter
            )
        )
    }


    fun clickPelicula(pelicula: Pelicula){
        println("Has hecho click en: ${pelicula.titulo}")
        _selectedPelicula.value = pelicula
    }
}