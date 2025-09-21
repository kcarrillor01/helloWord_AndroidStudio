package com.example.holamundo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val etPassword = findViewById<EditText>(R.id.editTextTextPassword)
        val btnLogin = findViewById<Button>(R.id.buttonLogin)
        val linkRegister = findViewById<TextView>(R.id.registrateLink)
        val linkRecover = findViewById<TextView>(R.id.recuperaClave)

        // Ignoramos validaciones según tu pedido.
        btnLogin.setOnClickListener {
            // Tomamos email como "usuario" para enviar a Profile (si quieres enviar más campos, añade aquí)
            val email = etEmail.text.toString().ifEmpty { "usuario@ejemplo.com" }

            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("name", "Nombre Apellido")    // quita/ajusta si traes del servidor
                putExtra("email", email)
                putExtra("birthYear", "1990")
            }
            startActivity(intent)
            finish() // cerramos Login para que no vuelva con Back
        }

        linkRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        linkRecover.setOnClickListener {
            val intent = Intent(this, RecoverPasswordActivity::class.java)
            startActivity(intent)
            // aquí no llamamos finish() para que el usuario pueda volver al login
        }
    }
}
