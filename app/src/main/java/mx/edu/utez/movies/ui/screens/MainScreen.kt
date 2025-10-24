package mx.edu.utez.movies.ui.screens

import android.R.attr.contentDescription
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.tooling.preview.Preview
import mx.edu.utez.movies.data.model.NavItem
import mx.edu.utez.movies.ui.components.PeliculaCard
import mx.edu.utez.movies.ui.theme.MoviesTheme

@Composable
fun MainScreen(modifier : Modifier = Modifier){
    val navItemList = listOf(
        NavItem("Agregar", Icons.Default.Add),
        NavItem("Editar", Icons.Default.Edit),
        NavItem("Eliminar", Icons.Default.Delete),
        NavItem("Salir", Icons.Default.ExitToApp),
    )
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed{ index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "icon")
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }

        }
    ){
        innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex )
    }
}



@Composable
fun ContentScreen(modifier : Modifier = Modifier,selectedIndex: Int ){
when(selectedIndex){

}
}


@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MoviesTheme {
        MainScreen()
    }

}