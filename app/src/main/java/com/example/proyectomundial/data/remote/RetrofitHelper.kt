package com.example.proyectomundial.data.remote

import com.example.proyectomundial.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    // Nos va a generar una instancia Singleton. No importa cuantas veces yo,
    // utilice este objeto, Retrofit solamente lo va a instanciar una sola vez

    // En la práctica profesional se usa la práctica de inyección de dependencias.
    // Con una librería de inyección de dependencias, en cualquier clase donde yo necesite
    // una instancia de Retrofit, esta nos la da. Popular: Koin, etc. También la inyecta con
    // patrón Singleton
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(MundialApi::class.java)

}