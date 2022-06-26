package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class mainactivityFirst : AppCompatActivity() {

    lateinit var register: Button
    lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainfirst)

        register=findViewById(R.id.main_register)
        login=findViewById(R.id.main_login)

        login.setOnClickListener {
            var intent= Intent(this@mainactivityFirst,Loginactivity::class.java)
            startActivity(intent)
        }

        register.setOnClickListener {
          var intent= Intent(this@mainactivityFirst,RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}