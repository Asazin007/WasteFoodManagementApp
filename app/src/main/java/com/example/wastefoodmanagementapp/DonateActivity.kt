package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DonateActivity : AppCompatActivity() {
    lateinit var lstview :ListView
    lateinit var ngoname :String
    lateinit var location:String
     var img_donate : Int = 0
    var donatebox = ArrayList<Model>()
    lateinit var bottomNavigationView: BottomNavigationView
    //    ------------------fab buttons
    lateinit var fab: FloatingActionButton
    lateinit var fab_recive: ExtendedFloatingActionButton
    lateinit var fab_donate: ExtendedFloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate)
//        ---------initialization
        fab=findViewById(R.id.floatingActionButton)
        fab_donate=findViewById(R.id.extendedFab_donate)
        fab_recive=findViewById(R.id.extendedFab_receive)
        bottomNavigationView=findViewById(R.id.bottom_navigation)
        lstview= findViewById(R.id.donate_lst_view)
//        -------------adding in array list
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


//        -----------------------fab
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
        fab_donate.setOnClickListener {
            var upload_intent = Intent(this, My_Donate::class.java)
            startActivity(upload_intent)
        }
        fab_recive.setOnClickListener {
            var receive_intent = Intent(this, My_Recieve::class.java)
            startActivity(receive_intent)
        }
    }

}