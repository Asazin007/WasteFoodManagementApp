package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    lateinit var donatebtn :Button
    lateinit var recievebtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //inisialization
        donatebtn = findViewById(R.id.donatebtn)
        recievebtn= findViewById(R.id.recievebtn)
        donatebtn.setOnClickListener {
            var intent1= Intent(this@MainActivity2,DonateActivity::class.java)
            startActivity(intent1)
        }
    }
}