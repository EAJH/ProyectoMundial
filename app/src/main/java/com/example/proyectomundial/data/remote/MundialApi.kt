package com.example.proyectomundial.data.remote

import com.example.proyectomundial.data.remote.model.SquadsResponseDto
import com.example.proyectomundial.data.remote.model.TeamsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MundialApi {

    // Se programan las funciones para consumir los endpoints.

    // Endpoints de prueba:
    // https://www.computomovil.com/2026-2/teams2026.php?league=1&season=2026
    // https://www.computomovil.com/2026-2/squads.php?team=16

    // Se separan en dos partes, el base URL y el que es el endpoint
    // Base url: https://www.computomovil.com/


    // Para que funcione con retrofit tenemos que meterle otra notación
    // ------ PRIMER ENDPOINT ------
    // https://www.computomovil.com/2026-2/teams2026.php?league=1&season=2026
    @GET("2026-2/teams2026.php") // teams --> ENDPOINT FINAL
    suspend fun getTeams(
        @Query("league") league: Int = 1, // Con @Query es para elementos dinámicos de mi URL
        @Query("season") season: Int = 2026
    ): TeamsResponseDto


    // ------ SEGUNDO ENDPOINT ------
    // https://www.computomovil.com/2026-2/squads.php?team=16
    @GET("2026-2/squads.php")  // players/squads --> ENDPOINT FINAL
    suspend fun getTeamPlayers(
        @Query("team") team: Int = 16
    ): SquadsResponseDto

    /*
    * Usamos suspended functions para que estas se ejecuten de manera asíncrona en un hilo de
    * fondo usando co rutinas, para que no se congele la interfaz mientras se obtienen los
    * datos de la aplicación.
    * */
}

