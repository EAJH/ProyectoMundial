package com.example.proyectomundial.data.remote.model

import com.google.gson.annotations.SerializedName

data class TeamSquad(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("logo")
    val logo: String
)
