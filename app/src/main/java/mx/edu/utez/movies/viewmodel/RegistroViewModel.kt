package mx.edu.utez.movies.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class RegistroViewModel : ViewModel() {

    // Estados de los campos de entrada
    var email = mutableStateOf("")
    var username = mutableStateOf("")
    var password = mutableStateOf("")
    var confirmPassword = mutableStateOf("")

    // Mensaje de error o validación
    var errorMessage = mutableStateOf("")

    // Función para actualizar valores (opcional, depende cómo uses los UserInputField)
    fun onEmailChange(newEmail: String) {
        email.value = newEmail
    }

    fun onUsernameChange(newUsername: String) {
        username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        password.value = newPassword
    }

    fun onConfirmPasswordChange(newConfirm: String) {
        confirmPassword.value = newConfirm
    }

    // Lógica de registro
    fun onRegisterClick(navController: NavController) {
        if (validateFields()) {
            // Aquí podrías hacer una llamada a tu repositorio o backend
            // Por ejemplo:
            // repository.register(email.value, username.value, password.value)

            // Navegar a otra pantalla si el registro fue exitoso
            navController.navigate("home") // ejemplo
        }
    }

    // Validaciones básicas
    private fun validateFields(): Boolean {
        if (email.value.isBlank() || username.value.isBlank() ||
            password.value.isBlank() || confirmPassword.value.isBlank()
        ) {
            errorMessage.value = "Todos los campos son obligatorios"
            return false
        }
        if (password.value != confirmPassword.value) {
            errorMessage.value = "Las contraseñas no coinciden"
            return false
        }
        if (!email.value.contains("@")) {
            errorMessage.value = "El correo no es válido"
            return false
        }

        errorMessage.value = ""
        return true
    }
}
