package com.example.proyectomundial.data.remote.model

import com.google.gson.annotations.SerializedName

data class ResponseTeam(
    @SerializedName("team")
    val team: Team,

    @SerializedName("venue")
    val venue: Venue
)
