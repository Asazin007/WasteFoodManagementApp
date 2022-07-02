package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Loginactivity : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var login: Button
    var name:String=" "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginactivity)
        email=findViewById(R.id.et_login_email)
        password=findViewById(R.id.et_login_pass)
        login=findViewById(R.id.log_pass)

        login.setOnClickListener {

            name=email.text.toString()
       var intent = Intent(this@Loginactivity,MainActivity2::class.java)
            startActivity(intent)

        }
    }
}