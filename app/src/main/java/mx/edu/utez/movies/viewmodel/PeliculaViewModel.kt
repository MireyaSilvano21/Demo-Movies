package mx.edu.utez.movies.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import mx.edu.utez.movies.data.model.DatabaseProvider
import mx.edu.utez.movies.data.model.Pelicula
import mx.edu.utez.movies.data.repository.PeliculaRepository

class PeliculaViewModel(private val repository: PeliculaRepository) : ViewModel() {

    // Live list of movies
    val peliculas: StateFlow<List<Pelicula>> = repository.allPeliculas
        .map { list -> list.filter { it.titulo.isNotBlank() } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _selectedPelicula = MutableStateFlow<Pelicula?>(null)
    val selectedPelicula: StateFlow<Pelicula?> = _selectedPelicula

    fun clickPelicula(pelicula: Pelicula) {
        _selectedPelicula.value = pelicula
    }

    fun eliminarPelicula() {
        _selectedPelicula.value?.let {
            viewModelScope.launch { repository.eliminarPelicula(it) }
            _selectedPelicula.value = null
        }
    }

    fun actualizarPelicula(pelicula: Pelicula) {
        viewModelScope.launch { repository.actualizarPelicula(pelicula) }
    }
}

// Factory
class PeliculaViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dao = DatabaseProvider.getDatabase(context).peliculaDao()
        val repo = PeliculaRepository(dao)
        return PeliculaViewModel(repo) as T
    }
}
