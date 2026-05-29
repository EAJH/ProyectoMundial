package com.example.proyectomundial.ui.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectomundial.data.remote.model.Group
import com.example.proyectomundial.ui.theme.blanco
import com.example.proyectomundial.ui.theme.grisClaro
import com.example.proyectomundial.ui.theme.grisOscuro
import com.example.proyectomundial.ui.theme.verdeBandera

@Composable
fun GroupItem(
    group: Group,
    onNavigateToCountry: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    // Contexto del activity para manejo de Toasts.
    // De esta forma no pasamos contextos por parámetros y la app es escalable.
    val context = LocalContext.current


    // Column ordena los elementos de arriba a abajo, Row de izquierda a derecha
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(16.dp))
    ){
        // Column wrap para poner el color de fondo a cada GroupItem
        Column(
            modifier = Modifier
                .background(grisClaro)
        ) {
            // ----------- Título verde con el grupo -----------
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(verdeBandera)
                    .padding(16.dp)
            ) {
                Text(
                    text = group.nombre,
                    color = blanco,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }

            // ----------- Todo debajo del título verde -----------
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp) // Padding interno para que los elementos no estén amontonados
            ) {
                Text(
                    text = "EQUIPOS",
                    color = grisOscuro,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                // Iteramos sobre la lista de equipos para crear los rows dinámicamente
                group.teams.forEach { team ->
                    TeamItem(
                        team = team,
                        onTeamClick = { idTeam ->
                            // Manejo de los clics
                            // Para rápido, vamos a mandar el clic a los logs
                            Log.d(
                                "APPLOGS",
                                "Clic en el equipo de país ${team.nombre}"
                            )

                            // Toast al hacer clic
                            // El Toast no es un Composable, viene de la herencia de XML
                            Toast.makeText(
                                context,
                                "Clic en el equipo de país ${team.nombre}",
                                Toast.LENGTH_SHORT
                            ).show()


                            // Ejecutamos la navegación
                            onNavigateToCountry(idTeam)
                        }

                    )

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                }
            }
        }



    }
}
