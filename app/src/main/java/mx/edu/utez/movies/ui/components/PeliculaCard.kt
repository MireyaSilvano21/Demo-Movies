package mx.edu.utez.movies.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.edu.utez.movies.data.model.Pelicula
import mx.edu.utez.movies.R
import mx.edu.utez.movies.ui.theme.MoviesTheme

@Composable
fun PeliculaCard(
    p: Pelicula,
    x: (Pelicula) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp), // Padding alrededor de la Card
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp) // Sombra
    ) {
        // 2. El contenido de la tarjeta es un Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                // Hacemos que toda la Card sea clickeable, pero solo el botón dispara la acción de editar.
                .clickable { /* Opcional: acción al hacer clic en toda la tarjeta */ }
                .padding(12.dp), // Padding dentro de la Card
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Bloque A: Placeholder de Imagen
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .border(1.dp, Color.Gray.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.dinero),

                    contentDescription = "imagen de la persona",
                    modifier = Modifier.width(90.dp),)
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Bloque B: Texto de Detalles
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = p.titulo, style = MaterialTheme.typography.titleMedium)
                Text(text = p.genero, style = MaterialTheme.typography.bodyMedium)
                Text(text = p.year.toString(), style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = p.sinopsis,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 1,
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Bloque C: Botón de Editar
            Column(
                modifier = Modifier
                    .clickable {x(p) } // SOLO ESTE CLICK DISPARA LA EDICIÓN
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Editar ${p.titulo}",
                    modifier = Modifier.size(24.dp)
                )
                Text(text = "Editar", fontSize = 12.sp)
            }
        }
    }
}





