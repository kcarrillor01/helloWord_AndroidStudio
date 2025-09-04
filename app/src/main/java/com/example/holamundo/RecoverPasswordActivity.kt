package com.example.holamundo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RecoverPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recover_password)

        val etEmail = findViewById<EditText>(R.id.editTextRecoverEmail)
        val btnSend = findViewById<Button>(R.id.buttonSendRecover)

        btnSend.setOnClickListener {
            val email = etEmail.text.toString().ifEmpty { "" }
            // Ignoramos validaciones: solo simulamos enviar
            Toast.makeText(this, "Se envió enlace de recuperación a: $email", Toast.LENGTH_LONG).show()
            finish() // regresamos al Login
        }
    }
}
