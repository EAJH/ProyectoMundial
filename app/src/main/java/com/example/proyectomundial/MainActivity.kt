package com.example.proyectomundial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectomundial.model.Group
import com.example.proyectomundial.model.Team
import com.example.proyectomundial.ui.screens.MainScreen
import com.example.proyectomundial.ui.theme.ProyectoMundialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val groups = mutableListOf<Group>()

        // Listado de 10 grupos que siguen el siguiente flujo:
        // MainScreen --> LazyColumn --> items --> Genera composables GroupItem en cada iteración
        repeat(10){ index ->
            groups.add(
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

        setContent {
            ProyectoMundialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        // Le paso los paddings del Scaffold a mi MainScreen a través del modifier
                        groups,
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}
