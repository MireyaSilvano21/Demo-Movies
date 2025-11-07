package mx.edu.utez.movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import mx.edu.utez.movies.R
import mx.edu.utez.movies.data.model.Pelicula
import mx.edu.utez.movies.data.repository.PeliculaRepository

class PeliculaViewModel(private val repository: PeliculaRepository) : ViewModel() {

    val peliculasUIState: StateFlow<List<Pelicula>> = repository.allPeliculas
        .stateIn(
            scope = viewModelScope,
            started = kotlinx.coroutines.flow.SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addNewPelicula(id: Int, titulo: String, genero: String, year: Int, sinopsis: String, imagen: Int){
        viewModelScope.launch {
            val newPelicula = Pelicula(id = id, titulo = titulo, genero = genero, year = year, sinopsis = sinopsis, imagen = imagen)
            repository.insertPelicula(newPelicula)
        }
    }

    private val _peliculas = MutableStateFlow<List<Pelicula>>(emptyList())
    val peliculas: StateFlow<List<Pelicula>> = _peliculas

    private val _selectedPelicula = MutableStateFlow<Pelicula?>(null)
    val selectedPelicula: StateFlow<Pelicula?> = _selectedPelicula

    init {
        _peliculas.value = listOf(
            Pelicula(
                id = 1,
                titulo = "Harry Potter y la Piedra Filosofal",
                genero = "Fantasía / Aventura",
                year = 2001,
                sinopsis = "Un niño huérfano descubre que es mago y comienza su educación en el mágico Colegio Hogwarts.",
                imagen = R.drawable.harrypotter
            ),
            Pelicula(
                id = 2,
                titulo = "Alicia en el país de las Maravillas",
                genero = "Fantasía / Aventura",
                year = 2001,
                sinopsis = "Una niña cae en un extraño mundo onírico habitado por seres absurdos y busca desesperadamente el camino a casa.",
                imagen = R.drawable.aliceinwonderland
            ),
            Pelicula(
                id = 3,
                titulo = "Coraline",
                genero = "Fantasía Oscura/Misterio",
                year = 2009,
                sinopsis = "Una niña halla una puerta a un mundo alternativo que parece perfecto, pero resulta ser una trampa de una madre malvada.",
                imagen = R.drawable.coraline
            ),
            Pelicula(
                id = 4,
                titulo = "El Libro de la Vida",
                genero = "Animación/Aventura",
                year = 2014,
                sinopsis = "Un músico realiza un viaje épico a través de los mundos de los muertos para recuperar a su amada, cumpliendo una apuesta divina.",
                imagen = R.drawable.el_libro_de_la_vida
            ),


        )
    }

    fun clickPelicula(pelicula: Pelicula) {
        println("Has hecho click en: ${pelicula.titulo}")
        _selectedPelicula.value = pelicula
    }
    fun eliminarPelicula() {
        val pelicula = _selectedPelicula.value
        if (pelicula != null) {
            _peliculas.value = _peliculas.value.filter { it.id !=pelicula.id }
            _selectedPelicula.value = null
            println("Película eliminada: ${pelicula.titulo}")
        }
    }
    fun actualizarPelicula(titulo: String, genero: String, year: Int, sinopsis: String) {
        val pelicula = _selectedPelicula.value ?: return
        val peliculasActualizadas = _peliculas.value.map {
            if (it.id == pelicula.id) {
                it.copy(
                    titulo = titulo,
                    genero = genero,
                    year = year,
                    sinopsis = sinopsis
                )
            } else it
        }
        _peliculas.value = peliculasActualizadas
        _selectedPelicula.value = null
        println("Película actualizada: $titulo")
    }
}
