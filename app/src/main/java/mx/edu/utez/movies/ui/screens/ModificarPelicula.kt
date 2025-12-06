package mx.edu.utez.movies.ui.screens

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import mx.edu.utez.movies.ui.components.buttons.PrimaryButton
import mx.edu.utez.movies.ui.components.images.ImagePicker
import mx.edu.utez.movies.ui.components.inputs.NuevaSinopsisField
import mx.edu.utez.movies.ui.components.inputs.NuevoGeneroField
import mx.edu.utez.movies.ui.components.inputs.NuevoTituloField
import mx.edu.utez.movies.ui.components.inputs.NuevoYearField
import mx.edu.utez.movies.viewmodel.PeliculaViewModel
import mx.edu.utez.movies.viewmodel.PeliculaViewModelFactory

@Composable
fun ModificarPelicula(
    navController: NavController
) {
    val context = LocalContext.current
    val viewModel: PeliculaViewModel = viewModel(factory = PeliculaViewModelFactory(context))

    val pelicula by viewModel.selectedPelicula.collectAsStateWithLifecycle()

    // Si no hay película seleccionada, regresa
    if (pelicula == null) {
        navController.popBackStack()
        return
    }

    var updatedTitulo by remember { mutableStateOf(pelicula!!.titulo) }
    var updatedGenero by remember { mutableStateOf(pelicula!!.genero) }
    var updatedYear by remember { mutableStateOf(pelicula!!.year.toString()) }
    var updatedSinopsis by remember { mutableStateOf(pelicula!!.sinopsis) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        ImagePicker(onImageSelected = { uri ->
            imageUri = uri
        })

        NuevoTituloField(
            initialValue = updatedTitulo,
            onValueChange = { updatedTitulo = it },
            label = "Nuevo Título"
        )

        NuevoGeneroField(
            initialValue = updatedGenero,
            onValueChange = { updatedGenero = it },
            label = "Nuevo Género"
        )

        NuevoYearField(
            initialValue = updatedYear,
            onValueChange = { updatedYear = it },
            label = "Nuevo Año"
        )

        NuevaSinopsisField(
            initialValue = updatedSinopsis,
            onValueChange = { updatedSinopsis = it },
            label = "Nueva Sinopsis"
        )

        PrimaryButton("Modificar") {

            val peliculaActualizada = pelicula!!.copy(
                titulo = updatedTitulo,
                genero = updatedGenero,
                year = updatedYear.toIntOrNull() ?: pelicula!!.year,
                sinopsis = updatedSinopsis,
                imagenUri = imageUri?.toString() ?: pelicula!!.imagenUri
            )

            viewModel.actualizarPelicula(peliculaActualizada)

            navController.popBackStack() // volver a la lista
        }
    }
}

