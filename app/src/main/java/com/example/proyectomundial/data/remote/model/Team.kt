package com.example.proyectomundial.data.remote.model

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val nombre: String,
    @SerializedName("code")
    val code: String?,
    @SerializedName("country")
    val country: String,
    @SerializedName("founded")
    val founded: Int?,
    @SerializedName("national")
    val national: Boolean,
    @SerializedName("logo")
    val logo: String,

    //@field:DrawableRes val bandera: Int
)