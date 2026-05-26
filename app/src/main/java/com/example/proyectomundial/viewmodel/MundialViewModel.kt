package com.example.proyectomundial.viewmodel

import androidx.lifecycle.ViewModel
import com.example.proyectomundial.R
import com.example.proyectomundial.data.remote.model.Group
import com.example.proyectomundial.data.remote.model.Team
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MundialViewModel: ViewModel() {
    // Estado interno del ViewModel que podemos modificar
    private val _grupos = MutableStateFlow<List<Group>>(emptyList())

    // Estado público que la MainScreen va a observar
    val grupos: StateFlow<List<Group>> = _grupos

    // Bloque init que se ejecuta automáticamente en cuanto nace el ViewModel
    init{
        // Al iniciar el ViewModel, cargamos los datos
        obtenerEquipos()
    }

    private fun obtenerEquipos(){
        _grupos.value = listOf(

            // Grupos de prueba
            Group(
                nombre="A",
                teams = listOf(
                    Team(1,"México", R.drawable.bandera_prueba),
                    Team(2,"Canadá", R.drawable.bandera_prueba),
                    Team(3,"Korea", R.drawable.bandera_prueba),
                    Team(4,"España", R.drawable.bandera_prueba)
                )
            ),

            Group(
                nombre="A",
                teams = listOf(
                    Team(1,"México", R.drawable.bandera_prueba),
                    Team(2,"Canadá", R.drawable.bandera_prueba),
                    Team(3,"Korea", R.drawable.bandera_prueba),
                    Team(4,"España", R.drawable.bandera_prueba)
                )
            )
        )
    }
}