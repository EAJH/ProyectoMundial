package com.example.proyectomundial.data.remote.model

import com.google.gson.annotations.SerializedName

data class Squad(
    @SerializedName("team")
    val team: TeamSquad,
    @SerializedName("players")
    val players: List<Player>
)
