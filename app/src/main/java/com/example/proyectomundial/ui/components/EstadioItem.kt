package com.example.proyectomundial.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Grass
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.proyectomundial.data.remote.model.Team
import com.example.proyectomundial.data.remote.model.Venue
import com.example.proyectomundial.ui.theme.blanco
import com.example.proyectomundial.ui.theme.greenBackground
import com.example.proyectomundial.ui.theme.negro
import com.example.proyectomundial.ui.theme.verdeBandera

@Composable
fun EstadioItem(
    modifier: Modifier = Modifier,
    team: Team,
    venue: Venue,
    onPlayersClick: (Int) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        // ------ Imagen bandera ------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(greenBackground)
                .padding(12.dp)

        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(team.logo),
                    contentDescription = "Imagen de bandera",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .width(270.dp)
                        .aspectRatio(1.5f) // 3:2 --> Rectángulo horizontal
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }


        // ------ Nombre estadio y ciudad ------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween, // Manda el título a la izq y ciudad a la der
            verticalAlignment = Alignment.Top
        ) {
            // ---- Nombre del estadio ----
            Text(
                modifier = Modifier.weight(1f),
                text = venue.name.uppercase(),
                color = negro,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ----- Ciudad del estadio -----
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "Ubicación",
                    tint = verdeBandera,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = venue.city,
                    color = negro,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    letterSpacing = 1.sp
                )
            }

        }

        // ------ Imagen estadio ------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp)
                //.background(greenBackground)
                .padding(12.dp)
                .clip(RoundedCornerShape(16.dp))
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(venue.image),
                    contentDescription = "Imagen de estadio",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        //.width(360.dp)
                        .fillMaxWidth()
                        .aspectRatio(1.5f) // 3:2 --> Rectángulo horizontal
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }

        // ------- Información del estadio -------
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = blanco
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp // Le damos una sombra para que resalte sobre el fondo
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                // ------- Capacidad y superficie del estadio --------
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // ------- Capacidad ------
                    Column(
                        modifier = Modifier
                            .weight(1.0f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Group,
                                contentDescription = "Capacidad",
                                tint = verdeBandera,
                                modifier = Modifier.size(20.dp)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Capacity",
                                color = negro,
                                fontWeight = FontWeight.Bold,
                                fontSize = 10.sp,
                                letterSpacing = 1.sp
                            )
                        }

                        Text(
                            text = venue.capacity.toString(),
                            color = negro,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            letterSpacing = 1.sp
                        )
                    }

                    // ------- Superficie -----
                    Column(
                        modifier = Modifier
                            .weight(1.0f)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Grass,
                                contentDescription = "Superficie",
                                tint = verdeBandera,
                                modifier = Modifier.size(20.dp)
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            Text(
                                text = "Surface",
                                color = negro,
                                fontWeight = FontWeight.Bold,
                                fontSize = 10.sp,
                                letterSpacing = 1.sp
                            )
                        }


                        Text(
                            text = venue.surface,
                            color = negro,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            letterSpacing = 1.sp
                        )
                    }

                }

                //Spacer(modifier = Modifier.height(4.dp))
                HorizontalDivider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(horizontal = 16.dp))

                // -------- Dirección del estadio ---------
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "Address",
                        color = negro,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        letterSpacing = 1.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = venue.address ?: "N/A",
                        color = negro,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp,
                        letterSpacing = 1.sp
                    )
                }

                //Spacer(modifier = Modifier.height(16.dp))

                // ------- Botón para ver jugadores --------
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onPlayersClick(team.id) }
                        .background(verdeBandera)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "Players",
                        color = blanco,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        letterSpacing = 1.sp
                    )
                }
            }

        }
    }
}