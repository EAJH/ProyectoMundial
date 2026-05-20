package com.example.proyectomundial.ui.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectomundial.R
import com.example.proyectomundial.ui.theme.blanco
import com.example.proyectomundial.ui.theme.rojoOscuro

@Composable
fun MainInfoItem(
    modifier: Modifier = Modifier
){
    // Box como contenedor raíz. Esto nos permite usar el modificador 'align'
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(220.dp) // Damos un tamaño fijo al Composable
            .clip(RoundedCornerShape(16.dp))
            .paint(
                painter = painterResource(R.drawable.estadio_main_screen),
                contentScale = ContentScale.Crop
            )
    ) {

        // -------- RECUADRO ROJO (TAG "LIVE STAGE") -------
        Box(
            modifier = Modifier
                .align(Alignment.TopStart) // Anclamos la etiqueta a la esquina superior izquierda
                .background(rojoOscuro)
                .padding(vertical = 6.dp, horizontal = 12.dp)
        ){
            Text(
                text = "LIVE STAGE",
                color = blanco,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        }

        // ------- TEXTOS INFERIORES -------
        // Envolvemos los textos en un Column y lo anclamos hasta abajo
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart) // Anclamos los textos a la esquina inferior izquierda
                .fillMaxWidth()
                .padding(16.dp) // Padding interno para que las letras no toquen los bordes de la imagen
        ) {
            Text(
                text = "EL CAMINO A LA GLORIA",
                color = blanco,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.noto_sans)),
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(4.dp)) // Espacio muy pequeño entre título y descripción

            Text(
                text = "La fase de grupos se pone interesante. ¿Quién sobrevivirá a la prueba y reclamará su lugar en las eliminatorias?",
                color = blanco,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.noto_sans)),
                fontSize = 14.sp,
                lineHeight = 18.sp
            )
        }
    }
}