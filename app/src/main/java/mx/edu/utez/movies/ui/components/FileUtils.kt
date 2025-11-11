package mx.edu.utez.movies.ui.components

import android.content.Context
import android.net.Uri
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

fun guardarImagenLocal(context: Context, uri: Uri): String? {
    return try {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        val nombreArchivo = "pelicula_${System.currentTimeMillis()}.jpg"
        val archivoDestino = File(context.filesDir, nombreArchivo)

        val outputStream = FileOutputStream(archivoDestino)
        inputStream?.copyTo(outputStream)
        inputStream?.close()
        outputStream.close()

        archivoDestino.absolutePath // Retorna la ruta absoluta del archivo guardado
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}