package com.example.proyectomundial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectomundial.R
import com.example.proyectomundial.model.Group
import com.example.proyectomundial.model.Team
import com.example.proyectomundial.ui.theme.ProyectoMundialTheme
import com.example.proyectomundial.ui.theme.blanco
import com.example.proyectomundial.ui.theme.grisClaro
import com.example.proyectomundial.ui.theme.grisOscuro
import com.example.proyectomundial.ui.theme.verdeBandera

@Composable
fun GroupItem(
    group: Group,
    modifier: Modifier = Modifier
){
    // Column ordena los elementos de arriba a abajo, Row de izquierda a derecha
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(16.dp))
    ){
        // Column wrap para poner el color de fondo a cada GroupItem
        Column(
            modifier = modifier
                .background(grisClaro)
        ) {
            // ----------- Título verde con el grupo -----------
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .background(verdeBandera)
                    .padding(16.dp)
            ) {
                Text(
                    text = "GRUPO ${group.nombre}",
                    color = blanco,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }

            // ----------- Todo debajo del título verde -----------
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp) // Padding interno para que los elementos no esten amontonados
            ) {
                Text(
                    text = "EQUIPOS",
                    color = grisOscuro,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = modifier.height(8.dp)
                )

                // Iteramos sobre la lista de equipos para crear los rows dinámicamente
                group.teams.forEach { team ->
                    TeamItem(team = team)
                    Spacer(modifier = modifier.height(8.dp))
                }
            }
        }



    }
}


@Preview(
    showBackground = true
)
@Composable
fun GroupItemPreview(){
    // Cargo el composable del tema para ver como este composable
    // se comporta de acuerdo al tema de mi aplicación
    ProyectoMundialTheme() {
        GroupItem(
            group = Group(
                nombre = "A",
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