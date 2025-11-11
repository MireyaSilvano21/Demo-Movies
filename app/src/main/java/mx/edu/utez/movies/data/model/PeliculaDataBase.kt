package mx.edu.utez.movies.data.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.jvm.java

@Database(entities = [Pelicula::class], version = 1, exportSchema = false)
abstract class PeliculaDataBase : RoomDatabase() {
    abstract fun peliculaDao(): PeliculaDAO
}

object DatabaseProvider {
    @Volatile
    private var INSTANCE: PeliculaDataBase? = null

    fun getDatabase(context: Context): PeliculaDataBase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                PeliculaDataBase::class.java,
                "peliculas_db"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
