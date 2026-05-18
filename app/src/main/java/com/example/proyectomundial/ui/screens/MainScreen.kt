package com.example.proyectomundial.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.proyectomundial.model.Group
import com.example.proyectomundial.ui.components.GroupItem

@Composable
fun MainScreen(
    groups: List<Group>,
    modifier: Modifier = Modifier
){
    // Todos los composables se van a cargar de manera perezosa.
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {

        // Imprime la lista de grupos del mundial de manera perezosa.
        items(groups){ group ->
            GroupItem(group)
        }
    }
}