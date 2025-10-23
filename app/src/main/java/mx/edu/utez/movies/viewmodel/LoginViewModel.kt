package mx.edu.utez.movies.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var password = mutableStateOf("")
    var username = mutableStateOf("")
    var loginError = mutableStateOf("")

    fun login(onSuccess: () -> Unit) {
        if (username.value == "admin" && password.value == "123") {
            loginError.value = ""
            onSuccess()
        } else {
            loginError.value = "Usuario o contraseña incorrectos"
        }
    }
}