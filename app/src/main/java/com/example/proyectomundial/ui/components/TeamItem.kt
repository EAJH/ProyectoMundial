package com.example.proyectomundial.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectomundial.R
import com.example.proyectomundial.model.Team
import com.example.proyectomundial.ui.theme.ProyectoMundialTheme
import com.example.proyectomundial.ui.theme.greenBackground
import com.example.proyectomundial.ui.theme.negro


@Composable
fun TeamItem(
    team: Team,
    modifier: Modifier = Modifier,
    onTeamClick: (Team) -> Unit
){
    // Necesito que el país sea clickable.
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(greenBackground)
            .clickable(
                onClick = {
                    // Este clic sería para cada equipo
                    onTeamClick(team)
                }
            )
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Dos columnas, en una va la bandera y en otra va el nombre
            // La primera usa el 30% de la pantalla y la otra el 70%
            // ------ BANDERA ------
            Column(
                modifier = modifier
                    .weight(0.3f)
            ) {
                Image(
                    painter = painterResource(team.bandera),
                    contentDescription = "Bandera del equipo",
                    modifier = modifier
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit
                )
            }

            // ------ NOMBRE PAÍS ------
            Column(
                modifier = modifier
                    .weight(0.7f)
                    .padding(start = 25.dp)
            ) {
                Text(
                    modifier = modifier
                        .fillMaxWidth(),
                    text = team.nombre,
                    color = negro,
                    fontFamily = FontFamily(Font(R.font.noto_sans)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
        }

    }
}



@Preview(
    showBackground = true
)
@Composable
fun TeamItemPreview(){
    // Cargo el composable del tema para ver como este composable
    // se comporta de acuerdo al tema de mi aplicación
    ProyectoMundialTheme() {
        TeamItem(
            team = Team(
                id = 0,
                nombre = "México",
                bandera = R.drawable.bandera_prueba
            )
        ){

        }
    }
}
