package com.example.proyectomundial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectomundial.R
import com.example.proyectomundial.ui.theme.blanco
import com.example.proyectomundial.ui.theme.negro

@Composable
fun CountItem(
    modifier: Modifier = Modifier,
    title: String,
    item: String,
    backgroundColor: Color
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(6.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor),
        contentAlignment = Alignment.Center // Alinea todo el contenido del Box exactamente en el centro
                                            // vertical y horizontalmente
    ){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            // Obligamos a que queden centrados todos los elementos dentro del Column
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                color = negro,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.noto_sans)),
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp)) // Espacio muy pequeño entre el título y los datos

            Text(
                text = item,
                color = negro,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.noto_sans)),
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}