package com.example.proyectomundial.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.proyectomundial.data.remote.model.Team
import com.example.proyectomundial.data.remote.model.Venue
import com.example.proyectomundial.ui.components.CountryTopItem
import com.example.proyectomundial.ui.components.EstadioItem
import com.example.proyectomundial.ui.theme.blanco
import com.example.proyectomundial.ui.theme.verdeBandera
import com.example.proyectomundial.viewmodel.MundialViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryScreen(
    teamId: Int,
    // Importamos el ViewModel
    viewModel: MundialViewModel,
    onNavigateToPlayers: (Int) -> Unit,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
){

    // Obtenemos la lista de 48 equipos equipos
    val teams by viewModel.teams.collectAsState()

    // Obtenemos la lista de los 48 estadios
    val venues by viewModel.venues.collectAsState()

    // Buscamos en la lista el equipo correcto de acuerdo al teamId y obtenemos
    // el equipo y su estado
    var equipoSeleccionado: Team? = null
    var venueSeleccionado: Venue? = null
    for (i in 0 until teams.size){
        if(teams[i].id == teamId){
            equipoSeleccionado = teams[i]
            venueSeleccionado = venues[i]
            break
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = blanco,
        topBar = {
            // Usamos la barra alineada al centro
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Equipo",
                        fontWeight = FontWeight.Bold
                    )
                },
                // Agregamos el parámetro navigationIcon para el botón de vuelta
                navigationIcon = {
                    IconButton(onClick = {
                        onNavigateBack()
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
            item {
                if(equipoSeleccionado != null){
                    CountryTopItem(
                        team = equipoSeleccionado
                    )
                }
            }

            item{
                if((equipoSeleccionado != null) && (venueSeleccionado != null)){
                    EstadioItem(
                        team = equipoSeleccionado,
                        venue = venueSeleccionado,
                        onPlayersClick = onNavigateToPlayers
                    )
                }

            }
        }
    }
}