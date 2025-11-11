package mx.edu.utez.movies.ui.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import mx.edu.utez.movies.data.model.Pelicula
import mx.edu.utez.movies.R
import mx.edu.utez.movies.ui.theme.MoviesTheme
import java.io.File
@Composable
fun PeliculaCard(
    p: Pelicula,
    onClick: (Pelicula) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(p) }
            .padding(horizontal = 12.dp, vertical = 4.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen o placeholder
            Box(
                modifier = Modifier
                    .size(width = 70.dp, height = 105.dp)
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.outline.copy(alpha = 0.4f),
                        shape = MaterialTheme.shapes.small
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (!p.imagenUri.isNullOrEmpty()) {
                    val file = File(p.imagenUri!!)
                    if (file.exists()) {
                        Image(
                            painter = rememberAsyncImagePainter(model = file),
                            contentDescription = "Poster de ${p.titulo}",
                            modifier = Modifier
                                .size(width = 70.dp, height = 105.dp)
                                .clip(MaterialTheme.shapes.small),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Image(
                            painter = painterResource(R.drawable.noposter),
                            contentDescription = "Poster vacío",
                            modifier = Modifier.size(width = 70.dp, height = 105.dp)
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.width(12.dp))

            // 👇👇 EL CAMBIO PRINCIPAL ES AQUÍ 👇👇
            // Usar .weight(1f) hace que esta Column tome todo el espacio disponible
            // en el Row, empujando el siguiente elemento (el Icon) hasta el final.
            Column(
                modifier = Modifier
                    .weight(1f) // 👈 ESTO SOLUCIONA EL ESPACIADO
                    .padding(vertical = 4.dp)
            ) {
                if (p.titulo.isNotBlank()) {
                    Text(
                        text = p.titulo,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                if (p.genero.isNotBlank()) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = p.genero,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Text(
                    text = p.year.toString(),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                if (p.sinopsis.isNotBlank()) {
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = p.sinopsis,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            // Se elimina el Spacer(modifier = Modifier.width(8.dp)) de aquí, ya que el weight(1f)
            // de la Column anterior se encarga de la distribución del espacio.

            // Icono de edición, que ahora estará a la derecha
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Editar ${p.titulo}",
                modifier = Modifier
                    .size(25.dp)
                    .clickable { onClick(p) },
                tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
            )
        }
    }
}




