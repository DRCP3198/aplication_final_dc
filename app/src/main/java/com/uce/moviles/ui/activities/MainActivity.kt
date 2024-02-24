package com.uce.moviles.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.uce.moviles.R
import com.uce.moviles.core.My_Application
import com.uce.moviles.databinding.ActivityMainBinding
import com.uce.moviles.logic.usercases.local.LoginUserCase
import com.uce.moviles.ui.core.Constants
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()

    }

    private fun initListeners() {
        binding.btnRegistre.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            var email = binding.editxtCorreo.text.toString()
            var password = binding.editxtContrasenia.text.toString()

            val intent = Intent(this, EjemploActivity::class.java)

            lifecycleScope.launch {
                val check =
                    LoginUserCase(My_Application.getConnectionDB())?.checkLogin(email, password)

                if (check ?: 0 > 0) {

                    startActivity(intent)

                } else {
                    Snackbar.make(
                        binding.root, "Usuario No registrado",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }

            }

        }
    }
}