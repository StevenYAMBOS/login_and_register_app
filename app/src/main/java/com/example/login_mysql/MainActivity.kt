package com.example.login_mysql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var button_signup: Button
    private lateinit var button_login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_signup = findViewById(R.id.button)
        button_login = findViewById(R.id.button2)

        button_signup.setOnClickListener{
            val intent = Intent(this, Sign_Up::class.java)
            startActivity(intent)
        }
        button_login.setOnClickListener{
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }
}