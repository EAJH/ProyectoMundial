package com.example.proyectomundial.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.proyectomundial.ui.screens.CountryScreen
import com.example.proyectomundial.ui.screens.MainScreen
import com.example.proyectomundial.ui.screens.PlayersScreen
import com.example.proyectomundial.viewmodel.MundialViewModel
import kotlinx.serialization.Serializable



@Composable
fun AppNavigation(
    viewModel: MundialViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainScreenDestination // Usamos el objeto directo
    ) {

        // 1. Pantalla Principal (MainScreen)
        composable<MainScreenDestination> {
            MainScreen(
                viewModel = viewModel,
                onNavigateToCountry = { idDelEquipo ->
                    // Navegamos pasando el objeto de datos, súper intuitivo
                    navController.navigate(CountryScreenDestination(teamId = idDelEquipo))
                }
            )
        }

        // 2. Pantalla de País (CountryScreen)
        composable<CountryScreenDestination> { backStackEntry ->
            // Recuperamos los datos de la pantalla anterior
            val datos = backStackEntry.toRoute<CountryScreenDestination>()
            CountryScreen(
                teamId = datos.teamId, // Pasamos el teamId a la pantalla
                viewModel = viewModel,
                onNavigateToPlayers = { idDelEquipo ->
                    // Navegamos pasando el objeto de datos, súper intuitivo
                    navController.navigate(PlayersScreenDestination(teamId = idDelEquipo))
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // 3. Pantalla de jugadores (PlayersScreen)
        composable<PlayersScreenDestination> { backStackEntry ->
            // Recuperamos los datos de la pantalla anterior
            val datos = backStackEntry.toRoute<PlayersScreenDestination>()
            PlayersScreen(
                teamId = datos.teamId, // Pasamos el teamId a la pantalla
                viewModel = viewModel,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}


// Ruta simple: No necesita recibir datos. Es la primer pantalla que mandamos llamar
@Serializable
object MainScreenDestination

// Ruta con parámetros: Necesitamos saber qué equipo seleccionó el usuario
@Serializable
data class CountryScreenDestination(
    val teamId: Int
)

@Serializable
data class PlayersScreenDestination(
    val teamId: Int
)