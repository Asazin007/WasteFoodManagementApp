package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import com.google.android.material.bottomnavigation.BottomNavigationView

class DonateActivity : AppCompatActivity() {
    lateinit var lstview :ListView
    lateinit var ngoname :String
    lateinit var location:String
     var img_donate : Int = 0
    var donatebox = ArrayList<Model>()
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate)
        bottomNavigationView=findViewById(R.id.bottom_navigation)
        lstview= findViewById(R.id.donate_lst_view)
        for (i in 1..5){
            ngoname="THE AKSHAY PATRA FOUNDATION"
            location="Phagwada, Punjab"
            img_donate = R.drawable.foodwaste
            donatebox.add(Model(ngoname,location,img_donate))
        }
        lstview.adapter= MyAdapter(this@DonateActivity,R.layout.row,donatebox)
        //-----------bottom nav
        bottomNavigationView.setOnItemSelectedListener {
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