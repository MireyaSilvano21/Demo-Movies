package mx.edu.utez.movies.ui.screens

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import mx.edu.utez.movies.ui.components.buttons.PrimaryButton
import mx.edu.utez.movies.ui.components.images.ImagePicker
import mx.edu.utez.movies.ui.components.inputs.NuevaSinopsisField
import mx.edu.utez.movies.ui.components.inputs.NuevoGeneroField
import mx.edu.utez.movies.ui.components.inputs.NuevoTituloField
import mx.edu.utez.movies.ui.components.inputs.NuevoYearField
import mx.edu.utez.movies.viewmodel.ModificarViewModel
import mx.edu.utez.movies.viewmodel.PeliculaViewModel

@Composable
fun ModificarPelicula(
    navController: NavController,
    viewModel: ModificarViewModel = viewModel()
) {var imageUri by remember { mutableStateOf<Uri?>(null) }

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


        NuevoTituloField(
            viewModel = viewModel,
            label = "Nuevo Titulo"
        )
        NuevoGeneroField(
            viewModel = viewModel,
            label = "Nuevo Genero"
        )

        NuevoYearField(
            viewModel = viewModel,
            label = "Nuevo Año"
        )

        NuevaSinopsisField(
            viewModel = viewModel,
            label = "Nueva Sinopsis"
        )

        PrimaryButton("Modificar") {

        }
    }

}
