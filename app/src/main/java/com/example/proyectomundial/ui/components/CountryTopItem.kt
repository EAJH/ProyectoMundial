package com.example.proyectomundial.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectomundial.R
import com.example.proyectomundial.data.remote.model.Team
import com.example.proyectomundial.ui.theme.blanco
import com.example.proyectomundial.ui.theme.negro
import com.example.proyectomundial.ui.theme.verdeBandera


@Composable
fun CountryTopItem(
    modifier: Modifier = Modifier,
    team: Team
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        // ------- Imagen copa del mundo -------
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .paint(
                    painter = painterResource(R.drawable.trofeo),
                    contentScale = ContentScale.Crop
                )

        ) {
            Text(
                text = team.nombre.uppercase(),
                color = negro,
                fontWeight = FontWeight.Bold,
                fontSize = 55.sp,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 16.dp, bottom = 8.dp)
            )
        }


        // ------- Imagen datos (founded y fifa code) -------
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            //.offset(y = (-20).dp), // ¡El truco! Esto "sube" la tarjeta 20dp para que muerda la imagen de arriba
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = blanco
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp // Le damos una sombra para que resalte sobre el fondo
            )
        ) {
            // Row para alinear los elementos de izquierda a derecha
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {

                // --- PRIMERA MITAD: FOUNDED ---
                Column(
                    modifier = Modifier.weight(1f) // 50% exacto del ancho
                ) {
                    Text(
                        text = "FOUNDED",
                        color = verdeBandera,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        letterSpacing = 1.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = team.founded.toString(),
                        color = negro,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp
                    )
                }

                // --- SEGUNDA MITAD: FIFA CODE ---
                Column(
                    modifier = Modifier.weight(1f) // El otro 50% del espacio
                ) {
                    Text(
                        text = "FIFA CODE",
                        color = verdeBandera,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        letterSpacing = 1.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = team.code ?: "N/A", // Si el código es nulo, muestra N/A
                        color = negro,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}
