package com.example.proyectomundial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.proyectomundial.ui.theme.ProyectoMundialTheme
import com.example.proyectomundial.ui.navigation.AppNavigation
import com.example.proyectomundial.viewmodel.MundialViewModel


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    // Instanciamos el ViewModel usando el delegado 'by viewModels()'
    // Esto asegura que los datos sobrevivan si el usuario gira la pantalla del celular
    private val viewModel: MundialViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoMundialTheme {
                AppNavigation(
                    viewModel = viewModel
                )
            }
        }
    }
}
