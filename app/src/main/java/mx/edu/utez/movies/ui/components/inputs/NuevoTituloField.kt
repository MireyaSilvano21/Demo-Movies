package mx.edu.utez.movies.ui.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NuevoTituloField(
    initialValue: String,
    onValueChange: (String) -> Unit,
    label: String = "Nuevo Título"
) {
    OutlinedTextField(
        value = initialValue,
        onValueChange = { onValueChange(it) },
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true
    )
}
