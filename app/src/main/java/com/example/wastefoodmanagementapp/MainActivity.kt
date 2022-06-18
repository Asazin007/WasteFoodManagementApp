package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    lateinit var cancelbtn: ImageView
    lateinit var phonelogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        phonelogin = findViewById(R.id.login_with_phone)
       cancelbtn= findViewById(R.id.cancel_btn)
        cancelbtn.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        phonelogin.setOnClickListener {


        }

    }
}