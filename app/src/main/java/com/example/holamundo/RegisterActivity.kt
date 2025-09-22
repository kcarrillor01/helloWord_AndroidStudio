package com.example.holamundo

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import android.content.Context
import android.content.Intent
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val inputName = findViewById<EditText>(R.id.registerName)
        val inputLastName = findViewById<EditText>(R.id.registerLastName)
        val inputUser = findViewById<EditText>(R.id.registerUser)
        val inputPassword = findViewById<EditText>(R.id.registerPassword)
        val inputConfirm = findViewById<EditText>(R.id.registerConfirmPassword)
        val registerButton = findViewById<Button>(R.id.buttonRegister)

        registerButton.setOnClickListener {
            val name = inputName.text.toString().trim()
            val lastName = inputLastName.text.toString().trim()
            val user = inputUser.text.toString().trim()
            val password = inputPassword.text.toString().trim()
            val confirmPassword = inputConfirm.text.toString().trim()

            if (name.isEmpty() || lastName.isEmpty() || user.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("user", user)
            editor.putString("password", password)
            editor.apply()

            Toast.makeText(this, "Registro exitoso: $name, $user", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
