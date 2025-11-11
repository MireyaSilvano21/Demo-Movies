package mx.edu.utez.movies.data.model

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "peliculas")
data class Pelicula (
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    val titulo: String,
    val genero: String,
    val year: Int,
    val sinopsis: String,
    val imagenUri: String? = null
)