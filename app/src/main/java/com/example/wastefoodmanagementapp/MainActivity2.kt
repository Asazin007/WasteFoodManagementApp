package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2 : AppCompatActivity() {
    lateinit var donatebtn :Button
    lateinit var recievebtn: Button
    lateinit var BottomNavigationView: BottomNavigationView
//    ------------------fab buttons
    lateinit var fab:FloatingActionButton
    lateinit var fab_recive:ExtendedFloatingActionButton
    lateinit var fab_donate:ExtendedFloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //inisialization
        donatebtn = findViewById(R.id.donatebtn)
        recievebtn= findViewById(R.id.recievebtn)
        BottomNavigationView=findViewById(R.id.bottom_navigation)
        fab=findViewById(R.id.floatingActionButton)
        fab_donate=findViewById(R.id.extendedFab_donate)
        fab_recive=findViewById(R.id.extendedFab_receive)
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
                R.id.account ->{
                    var loginintent=Intent(this,MainactivityFirst::class.java)
                    startActivity(loginintent)
                }
            }

            true
        }

//        -------------------------fab
        fab_donate.hide()
        fab_recive.hide()
        var flag = -1
        fab.setOnClickListener {
            if(flag==-1){
                fab_recive.show()
                fab_donate.show()

                flag=1
            }
            else{
                fab_donate.hide()
                fab_recive.hide()
                flag=-1
            }
        }

    }
}