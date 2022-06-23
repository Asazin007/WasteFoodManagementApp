package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity2 : AppCompatActivity() {
    lateinit var donatebtn :Button
    lateinit var recievebtn: Button
    lateinit var BottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //inisialization
        donatebtn = findViewById(R.id.donatebtn)
        recievebtn= findViewById(R.id.recievebtn)
        BottomNavigationView=findViewById(R.id.bottom_navigation)
        //------------listners
        //--------buttons
        donatebtn.setOnClickListener {
            var intent1= Intent(this@MainActivity2,DonateActivity::class.java)
            startActivity(intent1)
        }
        recievebtn.setOnClickListener {
            var intent2=Intent(this@MainActivity2,ReceiveActivity::class.java)
            startActivity(intent2)
        }


        //-----------------bottom nav
        BottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.team->{
                    var team_intent = Intent(this, TeamActivity::class.java)
                    startActivity(team_intent)
                }
            }
            true
        }
    }
}