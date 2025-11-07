package mx.edu.utez.movies.data.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Pelicula::class], version = 1, exportSchema = false)
abstract  class PeliculaDataBase {
    abstract fun peliculaDao(): PeliculaDAO

}