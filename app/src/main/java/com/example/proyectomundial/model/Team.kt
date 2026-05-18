package com.example.proyectomundial.model

import androidx.annotation.DrawableRes

data class Team(
    val id: Long,
    val nombre: String,
    @field:DrawableRes val bandera: Int
)
