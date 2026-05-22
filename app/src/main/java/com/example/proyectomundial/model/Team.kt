package com.example.proyectomundial.model

import androidx.annotation.DrawableRes

data class Team(
    val id: Int,
    val nombre: String,
    @field:DrawableRes val bandera: Int
)
