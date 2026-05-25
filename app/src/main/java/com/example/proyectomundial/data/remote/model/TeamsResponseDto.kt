package com.example.proyectomundial.data.remote.model

import com.google.gson.annotations.SerializedName

data class TeamsResponseDto(
    @SerializedName("response")
    val response: List<ResponseTeam>
)
