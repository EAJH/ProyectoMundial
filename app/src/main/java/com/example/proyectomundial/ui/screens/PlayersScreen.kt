package com.example.proyectomundial.ui.screens

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.proyectomundial.ui.theme.blanco
import com.example.proyectomundial.ui.theme.verdeBandera
import com.example.proyectomundial.viewmodel.MundialViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayersScreen(
    teamId: Int,
    viewModel: MundialViewModel,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
){
    // "Colectamos" el estado. Si la lista cambia en el ViewModel, esto redibuja la pantalla solo.
    // val groups by viewModel.grupos.collectAsState()

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
                Text(
                    text = "Pantalla PlayersScreen"
                )
            }
        }
    }
}