package com.example.proyectomundial.viewmodel

import androidx.lifecycle.ViewModel
import com.example.proyectomundial.R
import com.example.proyectomundial.data.remote.model.Group
import com.example.proyectomundial.data.remote.model.Team
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MundialViewModel: ViewModel() {
    // 1. Guardamos el estado (privado para que no se modifique desde fuera)
    private val _grupos = MutableStateFlow<List<Group>>(emptyList())

    // 2. Variable pública que la MainScreen va a escuchar
    val grupos: StateFlow<List<Group>> = _grupos.asStateFlow()

    init{
        // Al iniciar el ViewModel, cargamos los datos
        cargarDatos()
    }

    private fun cargarDatos(){
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