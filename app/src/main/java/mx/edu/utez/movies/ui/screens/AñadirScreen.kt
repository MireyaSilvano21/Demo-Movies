package mx.edu.utez.movies.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import mx.edu.utez.movies.ui.components.buttons.PrimaryButton
import mx.edu.utez.movies.ui.components.images.ImagePicker
import mx.edu.utez.movies.viewmodel.AñadirViewModel
import mx.edu.utez.movies.viewmodel.AñadirViewModelFactory

@Composable
fun AñadirScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val viewModel: AñadirViewModel = viewModel(factory = AñadirViewModelFactory(context))

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {

        // Picker de imagen
        ImagePicker(onImageSelected = { uri ->
            viewModel.imagenUri.value = uri
        })

        // Vista previa
        viewModel.imagenUri.value?.let { uri ->
            Image(
                painter = rememberAsyncImagePainter(uri),
                contentDescription = "Vista previa",
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
        }

        TextField(
            value = viewModel.titulo.value,
            onValueChange = { viewModel.titulo.value = it },
            label = { Text("Título") }
        )

        TextField(
            value = viewModel.genero.value,
            onValueChange = { viewModel.genero.value = it },
            label = { Text("Género") }
        )

        TextField(
            value = viewModel.year.value,
            onValueChange = { viewModel.year.value = it },
            label = { Text("Año") }
        )

        TextField(
            value = viewModel.sinopsis.value,
            onValueChange = { viewModel.sinopsis.value = it },
            label = { Text("Sinopsis") }
        )

        PrimaryButton("Agregar") {
            if (viewModel.titulo.value.isNotBlank() &&
                viewModel.genero.value.isNotBlank() &&
                viewModel.year.value.isNotBlank()
            ) {
                viewModel.insertarPelicula(context) {
                    navController.popBackStack()
                }
            }
        }
    }
}

