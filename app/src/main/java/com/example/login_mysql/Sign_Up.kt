package com.example.login_mysql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Sign_Up : AppCompatActivity() {

    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var confirm_password : EditText
    private lateinit var signup_button : Button
    private lateinit var database : DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        username = findViewById(R.id.editTextUsername)
        password = findViewById(R.id.editTextPassword)
        confirm_password = findViewById(R.id.editTextConfirmPassword)
        signup_button = findViewById(R.id.button3)
        database = DBHelper(this)

        signup_button.setOnClickListener{
            val usernameText = username.text.toString()
            val passwordText = password.text.toString()
            val confirmPasswordText = confirm_password.text.toString()
            val savedata = database.insertData(usernameText, passwordText)

            if (TextUtils.isEmpty(usernameText)
                || TextUtils.isEmpty(passwordText)
                || TextUtils.isEmpty(confirmPasswordText)) {
                Toast.makeText(this, "Ajouter un nom d'utilisateur, mot de passe & confirmer le mot de passe",
                Toast.LENGTH_SHORT).show()
            } else {
                if (passwordText.equals(confirmPasswordText)) {
                    if (savedata == true) {
                        Toast.makeText(this, "Connexion réussie !", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, login::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "L'utilisateur existe", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Le mot de passe ne correspond pas", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}