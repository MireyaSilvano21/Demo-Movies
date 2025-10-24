package mx.edu.utez.movies.data.model

import androidx.annotation.DrawableRes

data class Pelicula (
    val id: Int,

    val titulo: String,
    val genero: String,
    val year: Int,
    val sinopsis: String,

    @DrawableRes val imagen: Int
)