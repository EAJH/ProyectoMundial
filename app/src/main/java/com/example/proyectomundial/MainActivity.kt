package com.example.proyectomundial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.proyectomundial.ui.screens.MainScreen
import com.example.proyectomundial.ui.theme.ProyectoMundialTheme
import com.example.proyectomundial.ui.theme.verdeBandera
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import com.example.proyectomundial.ui.theme.blanco
import com.example.proyectomundial.viewmodel.MundialViewModel


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    // Instanciamos el ViewModel usando el delegado 'by viewModels()'
    // Esto asegura que los datos sobrevivan si el usuario gira la pantalla del celular
    private val viewModel: MundialViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //val groups = mutableListOf<Group>()

        // Listado de 10 grupos que siguen el siguiente flujo:
        // MainScreen --> LazyColumn --> items --> Genera composables GroupItem en cada iteración
//        repeat(10){ index ->
//            groups.add(
//                Group(
//                    nombre="A",
//                    teams = listOf(
//                        Team(1,"México", R.drawable.bandera_prueba),
//                        Team(2,"Canadá", R.drawable.bandera_prueba),
//                        Team(3,"Korea", R.drawable.bandera_prueba),
//                        Team(4,"España", R.drawable.bandera_prueba)
//                    )
//                )
//            )
//        }

        setContent {
            ProyectoMundialTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = blanco,
                    topBar = {
                        // Usamos la barra alineada al centro
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = "Grupos del Mundial",
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            // Agregamos el parámetro navigationIcon para el botón de vuelta
                            navigationIcon = {
                                IconButton(onClick = {
                                    // !!!!!!!!!!!!!!!! NavController.popBackStack() !!!!!!!!!!!!!!


                                }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = "Botón para regresar"
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = verdeBandera,
                                titleContentColor = blanco,
                                navigationIconContentColor = blanco
                            )
                        )
                    }
                ) { innerPadding ->
                    MainScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
