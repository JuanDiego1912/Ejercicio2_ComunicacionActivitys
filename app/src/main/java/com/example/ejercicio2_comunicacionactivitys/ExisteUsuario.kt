package com.example.ejercicio2_comunicacionactivitys

import Clases.User
import Clases.UserRepository
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ExisteUsuario : AppCompatActivity() {

    lateinit var btVolver : Button
    lateinit var tvUsuario : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_existe_usuario)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvUsuario = findViewById(R.id.tvUsuario)
        btVolver = findViewById(R.id.btVolver)

        btVolver.setOnClickListener {
            onBackPressed()
        }

        val usuario = getUser()
    }

    fun getUser() : User? {

        val bdUsuarios = UserRepository()
        val userName = intent.getStringExtra("USER_NAME") ?: "Usuario desconocido"

        tvUsuario.text = "${tvUsuario.text} ${userName}"

        return bdUsuarios.getUser(userName)
    }
}