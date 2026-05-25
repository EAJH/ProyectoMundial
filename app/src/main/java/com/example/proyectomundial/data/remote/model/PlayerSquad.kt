package com.example.proyectomundial.data.remote.model

import com.google.gson.annotations.SerializedName

data class PlayerSquad(
    @SerializedName("players")
    val players: List<Player>
)
