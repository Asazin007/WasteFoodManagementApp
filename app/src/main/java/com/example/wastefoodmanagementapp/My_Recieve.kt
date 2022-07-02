package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class My_Recieve : AppCompatActivity() {
    lateinit var BottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_recieve)
        BottomNavigationView=findViewById(R.id.bottom_navigation)



        BottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.team->{
                    var team_intent = Intent(this, TeamActivity::class.java)
                    startActivity(team_intent)
                }
                R.id.home_menu->{
                    var home_intent = Intent(this, MainActivity2::class.java)
                    startActivity(home_intent)
                }
            }
            true
        }
    }
}