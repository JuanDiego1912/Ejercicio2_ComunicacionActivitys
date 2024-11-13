package com.example.ejercicio2_comunicacionactivitys

import Clases.User
import Clases.UserRepository
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val bdUsuario = UserRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etContraseña = findViewById<EditText>(R.id.etContraseña)
        val btComprobar = findViewById<Button>(R.id.btComprobar)

        btComprobar.setOnClickListener {

            if (etUsuario.text.toString().isBlank() || etContraseña.text.toString().isBlank()) {
                Toast.makeText(this,
                    "Introduce un usuario y/o una contraseña.",
                    Toast.LENGTH_SHORT)
                    .show()

            } else if (bdUsuario.validateUser(etUsuario.text.toString(), etContraseña.text.toString())) {

                val intent = Intent(this, ExisteUsuario::class.java)

                intent.putExtra("USER_NAME", etUsuario.text.toString())
                startActivity(intent)

            } else {
                Toast.makeText(this, "Usuario o clave incorrectos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}