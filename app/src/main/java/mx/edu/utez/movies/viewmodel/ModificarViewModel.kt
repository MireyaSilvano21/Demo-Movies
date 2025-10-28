package mx.edu.utez.movies.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class ModificarViewModel : ViewModel(){
    var titulo = mutableStateOf("")
    var genero = mutableStateOf("")
    var año = mutableStateOf("")
    var sinopsis = mutableStateOf("")



}