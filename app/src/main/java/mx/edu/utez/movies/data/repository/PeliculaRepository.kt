package mx.edu.utez.movies.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow
import mx.edu.utez.movies.data.model.Pelicula
import mx.edu.utez.movies.data.model.PeliculaDAO


class PeliculaRepository(private val peliculaDao: PeliculaDAO) {
    val allPeliculas: Flow<List<Pelicula>> = peliculaDao.obtenerTodasLasPeliculas()

    suspend fun insertPelicula(pelicula: Pelicula){
        peliculaDao.insertarPelicula(pelicula)
    }

}
