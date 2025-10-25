package mx.edu.utez.movies.ui.screens

import android.R.attr.contentDescription
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.edu.utez.movies.data.model.NavItem
import mx.edu.utez.movies.ui.components.PeliculaCard
import mx.edu.utez.movies.ui.theme.MoviesTheme
import mx.edu.utez.movies.viewmodel.LoginViewModel
import mx.edu.utez.movies.viewmodel.MainViewModel
import mx.edu.utez.movies.viewmodel.PeliculaViewModel

@Composable
fun MainScreen( viewModel: MainViewModel, navController: NavController ,modifier : Modifier = Modifier){

    val viewModel: PeliculaViewModel = viewModel()

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Agregar", Icons.Default.Add),
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
        // ¡LLAMADA CORREGIDA! Pasamos los valores dentro de los paréntesis.
        ContentScreen(
            modifier = Modifier.padding(paddingValues = innerPadding),
            selectedIndex = selectedIndex,
            viewModel = viewModel,
            navController = navController
        )
    }
}

@Composable
fun ContentScreen(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    viewModel: PeliculaViewModel,
    navController: NavController
){
    when(selectedIndex){
        // Index 0: "Home"
        0 -> PeliculaScreen(viewModel = viewModel, navController = navController)
        3 -> navController.navigate("login") // ejemplo: salir

        // Puedes agregar más pantallas aquí
        // 1 -> AgregarScreen(viewModel = viewModel, navController = navController)
        // 2 -> EliminarScreen(viewModel = viewModel, navController = navController)
        // 3 -> SalirScreen(navController = navController)
    }
}





