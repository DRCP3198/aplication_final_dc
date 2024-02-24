package com.uce.moviles.data.network.endpoints.juego

import com.uce.moviles.data.network.entities.jikan.juego.DataJuegos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JuegoEndpoint {

    @GET("games")
    suspend fun getJuegos(@Query("platform") platform: String): Response<DataJuegos>
}