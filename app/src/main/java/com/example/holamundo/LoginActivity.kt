package com.example.holamundo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textRegistration = findViewById<TextView>(R.id.registerLink)
        val textForgotPassword = findViewById<TextView>(R.id.recoverPasswordLink)
        val loginButton = findViewById<Button>(R.id.buttonLogin)

        val inputUser = findViewById<EditText>(R.id.loginUser)
        val inputPasswordField = findViewById<EditText>(R.id.loginPassword)

        // Ir al registro
        textRegistration.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Ir a recuperar contraseña
        textForgotPassword.setOnClickListener {
            val intent = Intent(this, RecoverPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Lógica de login
        loginButton.setOnClickListener {
            val user = inputUser.text.toString().trim()
            val password = inputPasswordField.text.toString().trim()

            val sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val savedUser = sharedPref.getString("user", "")
            val savedPassword = sharedPref.getString("password", "")

            if (user.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (user == savedUser && password == savedPassword) {
                Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
