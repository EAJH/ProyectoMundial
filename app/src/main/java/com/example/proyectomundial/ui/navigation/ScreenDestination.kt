package com.example.proyectomundial.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface ScreenDestination {


    /*
    * Una interfaz sellada significa que solamente puedo implementar esta interfaz aquí dentro
    * de este archivo. Como solo una clase puede extender una interfaz sellada desde el mismo
    * paquete en el que está definida esta última, tenemos encapsulamiento y organización en
    * nuestra estructura del proyecto.
    * */


    // Pongo mis destinos de navegación
    @Serializable
    object MainScreenDestination: ScreenDestination

    // Ruta con parámetros: Necesitamos saber qué equipo seleccionó el usuario
    @Serializable
    data class CountryScreenDestination(
        val teamId: Int
    ): ScreenDestination

    @Serializable
    data class PlayersScreenDestination(
        val teamId: Int
    ): ScreenDestination
}