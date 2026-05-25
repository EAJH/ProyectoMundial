package com.example.proyectomundial.data.remote.model

import com.example.proyectomundial.data.remote.model.Team

data class Group(
    val nombre: String,
    val teams: List<Team>
)