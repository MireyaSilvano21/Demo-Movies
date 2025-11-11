package mx.edu.utez.movies.ui.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import mx.edu.utez.movies.viewmodel.AñadirViewModel
import mx.edu.utez.movies.viewmodel.LoginViewModel


@Composable
fun SinopsisField(
    viewModel: AñadirViewModel,
    label: String = "Usuario",
    onNext: (() -> Unit)? = null
) {
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = viewModel.sinopsis.value,
        onValueChange = { viewModel.sinopsis.value = it },
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                onNext?.invoke() ?: focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Down)
            }
        )
    )
}
