package mx.edu.utez.movies.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AñadirViewModel : ViewModel() {

    var titulo = mutableStateOf("")
    var genero = mutableStateOf("")
    var año = mutableStateOf("")
    var sinopsisi = mutableStateOf("")



}