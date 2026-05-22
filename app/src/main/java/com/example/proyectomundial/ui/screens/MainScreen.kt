package com.example.proyectomundial.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.proyectomundial.ui.components.CountItem
import com.example.proyectomundial.ui.components.GroupItem
import com.example.proyectomundial.ui.components.MainInfoItem
import com.example.proyectomundial.ui.theme.grisClaro
import com.example.proyectomundial.ui.theme.verdeBandera
import com.example.proyectomundial.viewmodel.MundialViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontWeight
import com.example.proyectomundial.ui.theme.blanco

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    // Importamos el ViewModel
    viewModel: MundialViewModel,
    onNavigateToCountry: (Int) -> Unit,
    modifier: Modifier = Modifier
){

    // "Colectamos" el estado. Si la lista cambia en el ViewModel, esto redibuja la pantalla solo.
    val groups by viewModel.grupos.collectAsState()

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
        // Todos los composables se van a cargar de manera perezosa.
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            // En LazyColumn, cada Composable que queremos integrar a la pantalla se tienen que
            // usar las funciones item o items, dependiendo de si queremos dibujar un solo
            // Composable o una lista de estos

            // -------- RECUADRO SUPERIOR ---------
            item{
                MainInfoItem(modifier = Modifier)
            }


            // -------- CONTADORES DE GOLES Y DÍAS --------
            item{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    // Contador de goles
                    Column(
                        modifier = Modifier
                            .weight(0.4f)
                    ) {
                        // !!!!!!!!!!! MODIFICAR CON LOS DATOS RECOGIDOS !!!!!!!
                        CountItem(
                            title = "Goles totales",
                            item = "100",
                            backgroundColor = verdeBandera
                        )
                    }

                    // Contador de días
                    Column(
                        modifier = Modifier
                            .weight(0.6f)
                    ) {
                        // !!!!!!!!!!! MODIFICAR CON LOS DATOS RECOGIDOS !!!!!!!
                        CountItem(
                            title = "Días restantes para el mundial",
                            item = "100",
                            backgroundColor = grisClaro
                        )
                    }
                }
            }

            // ------- LISTA DE GRUPOS -------
            // Imprime la lista de grupos del mundial de manera perezosa.
            items(groups){ group ->
                GroupItem(
                    group = group,
                    onNavigateToCountry = onNavigateToCountry // // Pasamos la lambda que MainScreen ya había recibido
                )
            }
        }
    }
}