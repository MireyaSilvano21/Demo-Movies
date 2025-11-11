package mx.edu.utez.movies.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow // O usa List directamente

@Dao
interface PeliculaDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertarPelicula(pelicula: Pelicula)
    @Query("SELECT * FROM peliculas")
    fun obtenerTodasLasPeliculas(): Flow<List<Pelicula>>

    //@Delete
    //suspend fun eliminarPelicula(pelicula: Pelicula)

  //  @Update
   // suspend fun actualizarPelicula(pelicula: Pelicula)
}