package com.example.proyectomundial.data.remote.model

import com.google.gson.annotations.SerializedName

data class SquadsResponseDto(
    @SerializedName("response")
    val response: List<ResponseSquad>
)
