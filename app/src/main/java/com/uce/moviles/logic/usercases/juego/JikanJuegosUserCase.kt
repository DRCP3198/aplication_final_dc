package com.uce.moviles.logic.usercases.jikan

import android.util.Log
import com.uce.moviles.data.network.endpoints.anime.TopAnimesEndpoint
import com.uce.moviles.data.network.endpoints.juego.JuegoEndpoint
import com.uce.moviles.data.network.entities.jikan.juego.DataJuegos
import com.uce.moviles.data.network.entities.jikan.top.TopAnime
import com.uce.moviles.data.network.repository.RetrofitBase
import com.uce.moviles.data.network.repository.RetrofitBaseJuego
import com.uce.moviles.ui.core.Constants

class JikanJuegosUserCase {

    suspend fun getResponse(): Result<DataJuegos> {
        var result: Result<DataJuegos>? = null
        var infoAnime = DataJuegos()

        try {
            val baseService = RetrofitBaseJuego.getRetrofitJikanConnection()
            val service = baseService.create(JuegoEndpoint::class.java)
            val call = service.getJuegos("pc")

            if (call.isSuccessful) {

                val a = call.body()!!
                infoAnime = a
                result = Result.success(infoAnime)
            } else {
                Log.e(Constants.TAG, "Error en el llamado a la API de Jikan")
                result = Result.failure(Exception("Error en el llamado a la API de Jikan"))
            }
        } catch (ex: Exception) {
            Log.e(Constants.TAG, ex.stackTraceToString())
            result = Result.failure(Exception(ex))
        }

        return result!!
    }
}