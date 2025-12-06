package mx.edu.utez.movies.ui.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NuevaSinopsisField(
    initialValue: String,
    onValueChange: (String) -> Unit,
    label: String = "Nueva Sinopsis"
) {
    OutlinedTextField(
        value = initialValue,
        onValueChange = { onValueChange(it) },
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth()
    )
}
