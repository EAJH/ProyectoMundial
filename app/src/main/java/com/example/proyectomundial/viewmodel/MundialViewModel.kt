package com.example.proyectomundial.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectomundial.R
import com.example.proyectomundial.data.remote.RetrofitHelper.apiService
import com.example.proyectomundial.data.remote.model.Group
import com.example.proyectomundial.data.remote.model.Team
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MundialViewModel: ViewModel() {

    // ----------- MAINSCREEN -----------
    // Estado interno del ViewModel que podemos modificar
    private val _grupos = MutableStateFlow<List<Group>>(emptyList())

    // Estado público que la MainScreen va a observar
    val grupos: StateFlow<List<Group>> = _grupos


    // ----------- COUNTRY SCREEN ---------
    private val _teams = MutableStateFlow<List<Team>>(emptyList())
    val teams: StateFlow<List<Team>> = _teams




    // Bloque init que se ejecuta automáticamente en cuanto nace el ViewModel
    init{
        // Al iniciar el ViewModel, cargamos los datos
        loadData()
    }


    // Las funciones suspend solamente se pueden mandar a llamar en el ámbito de una co rutina
    // o dentro de otra función suspend

    // --------- OBTENCIÓN DE EQUIPOS Y GRUPOS MAINSCREEN ----------
    fun loadData(){
        // Co rutina exclusiva de este ViewModel
        viewModelScope.launch {
            try {
                val respuestaDto = apiService.getTeams()

                // Obtenemos los datos que nos interesan (solamente los equipos)
                val listaLimpia = respuestaDto.response.map { responseTeam ->
                    Team(
                        id = responseTeam.team.id,
                        nombre = responseTeam.team.nombre,
                        code = responseTeam.team.code ?: "N/A",
                        country = responseTeam.team.country,
                        founded = responseTeam.team.founded ?: 0,
                        national = responseTeam.team.national,
                        logo = responseTeam.team.logo
                    )
                }

                // La API devuelve los equipos en orden de acuerdo a los grupos, por lo que tenemos
                // que agruparlos en grupos de cuatro para ingresarlos al modelo de Group
                val listaGrupos = mutableListOf<Group>()
                val listaEquipos = mutableListOf<Team>()
                var equiposTemporales = mutableListOf<Team>()
                var indiceGrupo = 0 // Para saber la letra que asignar al grupo

                // Recorremos los 48 equipos
                for (i in 0 until listaLimpia.size){

                    // Metemos el equipo actual en la lista de equipos temporales
                    equiposTemporales.add(listaLimpia[i])

                    // Metemos los equipos en listaEquipos
                    listaEquipos.add(listaLimpia[i])

                    // Verificamos si ya llegamos a los cuatro grupos
                    if(equiposTemporales.size == 4){
                        // Calculamos la letra del grupo usando los valores del código ASCII
                        // 65 --> A
                        val letraGrupo = (65 + indiceGrupo).toChar()

                        // Armamos el objeto Group y lo guardamos en la lista de Grupos final
                        listaGrupos.add(
                            Group(
                                nombre = "Grupo $letraGrupo",
                                teams = equiposTemporales
                            )
                        )

                        // Limpiamos la lista de equipos temporales
                        equiposTemporales = mutableListOf()
                        //Aumentamos el índice para avanzar en el código ASCII y obtener la siguiente letra
                        indiceGrupo++
                    }
                }

                // Si sobraron equipos que no alcanzaron a formar un grupo de 4, los guardamos al final
                if (equiposTemporales.isNotEmpty()) {
                    val letraGrupo = (65 + indiceGrupo).toChar()
                    listaGrupos.add(Group("Grupo $letraGrupo", equiposTemporales))
                }

                // Pasamos la lista de Grupos finalizada a la UI
                _grupos.value = listaGrupos

                // Pasamos la lista de Equipos finalizada
                _teams.value = listaEquipos

            } catch (e: Exception){
                // Si algo falla, atrapamos el error para que la app no haga un crash
                Log.e("MundialViewModel", "Error al conectar con la API: ${e.message}")
            }
        }
    }





}