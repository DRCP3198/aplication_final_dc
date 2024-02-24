package com.uce.moviles.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.uce.moviles.R
import com.uce.moviles.core.My_Application
import com.uce.moviles.data.local.entities.Users
import com.uce.moviles.databinding.ActivityMainBinding
import com.uce.moviles.databinding.ActivityRegistroBinding
import com.uce.moviles.logic.usercases.local.LoginUserCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initControls()
        initListeners()
    }

    fun initListeners(){
        binding.btnRetorno.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun initControls(){
        binding.btnAceptar.setOnClickListener {

            var nombre= binding.editxtNombre.text.toString()
            var correo= binding.editxtCorreo.text.toString()
            var pass= binding.editxtContrasenia.text.toString()
            var edad= 0

            var  user = Users(nombre,correo,pass,edad)
            val intent = Intent(this, EjemploActivity::class.java)

            lifecycleScope.launch(Dispatchers.IO) {
                try {
                    val result = LoginUserCase(My_Application.getConnectionDB())?.insertSingleUser(user)
                    Snackbar.make(binding.root, "Usuario registrado", Snackbar.LENGTH_SHORT).show()


                    startActivity(intent)

                   // findNavController().navigate(R.id.action_signUpFragment_to_principalFragment)
                    // Maneja el resultado de la inserción aquí
                } catch (e: Exception) {
                    Log.d("TAG", "Error al insertar")
                }
            }


        }
    }
}