package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    lateinit var fullname: EditText
    lateinit var email: EditText
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var confirm: EditText
    lateinit var register: Button
    lateinit var login: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        fullname=findViewById(R.id.et_fullname)
        email=findViewById(R.id.et_email)
        username=findViewById(R.id.et_username)
        password=findViewById(R.id.etpassword)
        confirm=findViewById(R.id.et_confirmpassword)
        register=findViewById(R.id.reg_register)
        login=findViewById(R.id.reg_lasttitle)


        register.setOnClickListener {
          var intent= Intent(this@RegisterActivity,Loginactivity::class.java)
            startActivity(intent)
        }





        login.setOnClickListener {

         var intent= Intent(this@RegisterActivity,Loginactivity::class.java)
            startActivity(intent)
        }


    }
}