package mx.edu.utez.movies.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.movies.R
import mx.edu.utez.movies.ui.components.buttons.PrimaryButton
import mx.edu.utez.movies.ui.components.images.CircularImage
import mx.edu.utez.movies.ui.components.inputs.UserInputField
import mx.edu.utez.movies.ui.components.texts.Title
import mx.edu.utez.movies.viewmodel.RegistroViewModel

@Composable
fun RegistroScreen(
    viewModel: RegistroViewModel = viewModel(),
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        CircularImage(R.drawable.logo2)
        Title("Regístrate")

        UserInputField(viewModel, label = "Ingrese correo electrónico")
        UserInputField(viewModel, label = "Ingrese nombre de usuario")
        UserInputField(viewModel, label = "Ingrese contraseña")
        UserInputField(viewModel, label = "Confirme contraseña")

        PrimaryButton("Registrarse") {
            // Lógica del registro
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewRegistroScreen() {
    val navController = rememberNavController()
    val viewModel = RegistroViewModel()
    RegistroScreen(viewModel = viewModel, navController = navController)
}
