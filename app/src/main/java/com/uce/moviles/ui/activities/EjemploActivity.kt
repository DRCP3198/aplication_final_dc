package com.uce.moviles.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.uce.moviles.R
import com.uce.moviles.databinding.ActivityEjemploBinding
import com.uce.moviles.databinding.ActivityPrincipalBinding
import com.uce.moviles.logic.usercases.jikan.JikanJuegosUserCase
import com.uce.moviles.ui.adapters.AnimeAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EjemploActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEjemploBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjemploBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_ejemplo)
        initRecyclerView1()
    }
    private fun initRecyclerView1() {
        lifecycleScope.launch(Dispatchers.Main) {
            val jikan = JikanJuegosUserCase()
            val animes = withContext(Dispatchers.IO) { jikan.getResponse() }

            animes.onSuccess { animes ->
                val adapter = AnimeAdapter(animes)
                binding.rvJuego.adapter = adapter
                binding.rvJuego.layoutManager =
                    LinearLayoutManager(
                        this@EjemploActivity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )

            }
            animes.onFailure {
                // Manejo de errores en la UI
                // Depende lo que desee mostra al usuario
                // AlertDialog, SnackBar, Intent para enviar a otra vista para el error.
            }


           }
        }
}