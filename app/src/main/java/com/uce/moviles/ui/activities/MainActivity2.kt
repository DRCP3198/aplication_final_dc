package com.uce.moviles.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uce.moviles.R
import com.uce.moviles.databinding.ActivityMain2Binding
import com.uce.moviles.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
       iniciar()

    }
    fun iniciar(){
        binding.comenzar.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(intent)
        }
    }
}