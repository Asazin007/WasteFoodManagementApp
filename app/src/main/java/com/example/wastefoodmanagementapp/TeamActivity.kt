package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class TeamActivity : AppCompatActivity() {

    // Declarations
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var fab: FloatingActionButton
    lateinit var fab_recive: ExtendedFloatingActionButton
    lateinit var fab_donate: ExtendedFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)
//----------------------------------------fab
        fab=findViewById(R.id.floatingActionButton)
        fab_donate=findViewById(R.id.extendedFab_donate)
        fab_recive=findViewById(R.id.extendedFab_receive)
        //-----------------------DrawerLayout And Navigation View---------------------------------
        drawerLayout = findViewById(R.id.drawerLayout)
        bottomNavigationView=findViewById(R.id.bottom_navigation)
        navigationView = findViewById(R.id.navigationView)
        toggle = ActionBarDrawerToggle(this@TeamActivity, drawerLayout, R.string.Open, R.string.Close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        Interaction with the Drawer Navigation menu items
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.asim -> {
                    Toast.makeText(this@TeamActivity, "Asim", Toast.LENGTH_SHORT).show()
                }
                R.id.shoaib -> {
                    Toast.makeText(this@TeamActivity, "Shoaib", Toast.LENGTH_SHORT).show()
                }
                R.id.devesh -> {
                    Toast.makeText(this@TeamActivity, "Devesh", Toast.LENGTH_SHORT).show()
                }
                R.id.jayveer -> {
                    Toast.makeText(this@TeamActivity, "Jayveer", Toast.LENGTH_SHORT).show()
                }
                R.id.ankit -> {
                    Toast.makeText(this@TeamActivity, "Ankit", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

        //---------------------bottom nav listner
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
        getSupportActionBar()?.show()



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
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        when (item.itemId) {
            R.id.home_menu -> {
                Toast.makeText(this@TeamActivity,"You're Home", Toast.LENGTH_SHORT).show()
                var intent = Intent(this@TeamActivity, MainActivity2::class.java)
                startActivity(intent)
            }
            R.id.chat -> {
                Toast.makeText(this@TeamActivity,"Chats", Toast.LENGTH_SHORT).show()
//                var intent = Intent(this@TeamActivity, MainActivity2::class.java)
//                startActivity(intent)
            }
            R.id.noti -> {
                Toast.makeText(this@TeamActivity,"Notifications", Toast.LENGTH_SHORT).show()
//                var intent = Intent(this@TeamActivity, MainActivity2::class.java)
//                startActivity(intent)
            }
            R.id.account -> {
                Toast.makeText(this@TeamActivity,"Account details", Toast.LENGTH_SHORT).show()
//                var intent = Intent(this@TeamActivity, MainActivity2::class.java)
//                startActivity(intent)
            }
            R.id.team -> {
                Toast.makeText(this@TeamActivity, "You're already here", Toast.LENGTH_SHORT).show()
            }

        }
        return true




    }
}