package mx.edu.utez.movies.data.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PeliculaDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertarPelicula(pelicula: Pelicula)

    @Query("SELECT * FROM peliculas")
    fun obtenerTodasLasPeliculas(): Flow<List<Pelicula>>

    @Delete
    suspend fun eliminarPelicula(pelicula: Pelicula)

    @Update
    suspend fun actualizarPelicula(pelicula: Pelicula)
}
