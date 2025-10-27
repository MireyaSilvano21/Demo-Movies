package mx.edu.utez.movies.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class OlvidarContraViewModel : ViewModel() {

    // Estado para cada dígito del código
    var codeDigits = List(6) { mutableStateOf("") }

    // Mensaje de error (opcional)
    var errorMessage = mutableStateOf("")

    // Combina los dígitos en un solo string
    private fun getFullCode(): String = codeDigits.joinToString("") { it.value }

    // Validar y procesar el código
    fun onVerifyClick(navController: NavController) {
        val code = getFullCode()

        if (code.length < 6) {
            errorMessage.value = "Por favor, ingrese el código completo."
            return
        }

        // Aquí puedes validar el código con tu backend o lógica interna
        if (code == "123456") { // ejemplo temporal
            errorMessage.value = ""
            navController.navigate("home") // navega a la siguiente pantalla
        } else {
            errorMessage.value = "Código incorrecto."
        }
    }
}
