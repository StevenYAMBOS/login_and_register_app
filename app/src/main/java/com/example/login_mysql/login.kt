package com.example.login_mysql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login : AppCompatActivity() {

    private lateinit var login_button : Button
    private lateinit var editUsername : EditText
    private lateinit var editPassword : EditText
    private lateinit var dataBaseHelper : DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button = findViewById(R.id.loginButton)
        editUsername = findViewById(R.id.editTextUsernameLogin)
        editPassword = findViewById(R.id.editTextPasswordLogin)
        dataBaseHelper = DBHelper(this)

        login_button.setOnClickListener{
            val userEditText = editUsername.text.toString()
            val passwordEditText = editPassword.text.toString()

            if (TextUtils.isEmpty(userEditText) || TextUtils.isEmpty(passwordEditText)) {
                Toast.makeText(this, "Ajouter un nom d'utilisateur & un mot de passe", Toast.LENGTH_SHORT).show()
            } else {
                val checkUser = dataBaseHelper.checkUserPassword(userEditText, passwordEditText)
                if (checkUser == true) {
                    Toast.makeText(this, "Connexion réussie !", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, Success::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Mauvais nom d'utilisateur et mot de passe", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}