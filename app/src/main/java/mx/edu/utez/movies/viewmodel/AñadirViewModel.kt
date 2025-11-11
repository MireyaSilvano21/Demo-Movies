package mx.edu.utez.movies.viewmodel

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.edu.utez.movies.data.model.DatabaseProvider
import mx.edu.utez.movies.data.model.Pelicula
import mx.edu.utez.movies.data.repository.PeliculaRepository
import mx.edu.utez.movies.ui.components.guardarImagenLocal


class AñadirViewModel(private val repository: PeliculaRepository) : ViewModel() {

    var titulo = mutableStateOf("")
    var genero = mutableStateOf("")
    var year = mutableStateOf("")
    var sinopsis = mutableStateOf("")
    var imagenUri = mutableStateOf<Uri?>(null)

    fun insertarPelicula(context: Context, onSaved: () -> Unit) {
        viewModelScope.launch {
            val rutaImagenLocal = imagenUri.value?.let { guardarImagenLocal(context, it) }
            try {
                val pelicula = Pelicula(
                    titulo = titulo.value,
                    genero = genero.value,
                    year = year.value.toIntOrNull() ?: 0,
                    sinopsis = sinopsis.value,
                    imagenUri = rutaImagenLocal
                )
                repository.insertPelicula(pelicula)

                // Limpiar campos
                titulo.value = ""
                genero.value = ""
                year.value = ""
                sinopsis.value = ""
                imagenUri.value = null

                onSaved()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

// Factory
class AñadirViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dao = DatabaseProvider.getDatabase(context).peliculaDao()
        val repo = PeliculaRepository(dao)
        return AñadirViewModel(repo) as T
    }
}
