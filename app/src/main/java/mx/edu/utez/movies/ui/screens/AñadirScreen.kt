package mx.edu.utez.movies.ui.screens

import android.R.attr.label
import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.movies.R
import mx.edu.utez.movies.ui.components.buttons.PrimaryButton
import mx.edu.utez.movies.ui.components.images.CircularImage
import mx.edu.utez.movies.ui.components.inputs.GeneroField
import mx.edu.utez.movies.ui.components.inputs.ImagePicker
import mx.edu.utez.movies.ui.components.inputs.MovieField
import mx.edu.utez.movies.ui.components.inputs.PasswordField
import mx.edu.utez.movies.ui.components.inputs.SinopsisField
import mx.edu.utez.movies.ui.components.inputs.TituloField
import mx.edu.utez.movies.ui.components.inputs.UserInputField
import mx.edu.utez.movies.ui.components.inputs.YearField
import mx.edu.utez.movies.ui.components.texts.Link
import mx.edu.utez.movies.ui.components.texts.Title
import mx.edu.utez.movies.ui.theme.MoviesTheme
import mx.edu.utez.movies.viewmodel.AñadirViewModel
import mx.edu.utez.movies.viewmodel.LoginViewModel

@Composable
fun AñadirScreen(viewModel: AñadirViewModel, navController: NavController) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {

        ImagePicker(onImageSelected = { uri ->
            imageUri = uri
        })


        TituloField(
            viewModel = viewModel,
            label = "Titulo"
        )
        GeneroField(
            viewModel = viewModel,
            label = "Genero"
        )

        YearField(
            viewModel = viewModel,
            label = "Año"
        )

        SinopsisField(
            viewModel = viewModel,
            label = "Sinopsis"
        )

        PrimaryButton("Agregar") {

        }
    }

}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewAñadirScreen() {
    MoviesTheme {
        val navController = rememberNavController()
        val viewModel = AñadirViewModel()

        AñadirScreen(
            viewModel = viewModel,
            navController = navController
        )
    }
}
