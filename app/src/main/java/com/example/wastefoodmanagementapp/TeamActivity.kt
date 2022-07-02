package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class TeamActivity : AppCompatActivity() {

    // Declarations
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var body: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        //-----------------------DrawerLayout And Navigation View---------------------------------
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        body = findViewById(R.id.body)
        toggle = ActionBarDrawerToggle(this@TeamActivity, drawerLayout, R.string.Open, R.string.Close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        Interaction with the Drawer Navigation menu items
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.asim -> {
                    var intent = Intent(this@TeamActivity, AsimActivity::class.java)
                    startActivity(intent)
                }
                R.id.shoaib -> {
                    var intent = Intent(this@TeamActivity, ShoaibActivity::class.java)
                    startActivity(intent)
                }
                R.id.devesh -> {
                    var intent = Intent(this@TeamActivity, DeveshActivity::class.java)
                    startActivity(intent)
                }
                R.id.jayveer -> {
                    var intent = Intent(this@TeamActivity, JayActivity::class.java)
                    startActivity(intent)
                }
                R.id.ankit -> {
                    var intent = Intent(this@TeamActivity, AnkitActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }

        body.movementMethod = LinkMovementMethod.getInstance() //Activates the Github Link

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

            }
            R.id.noti -> {
                var intent = Intent(this@TeamActivity, NotiActivity::class.java)
                startActivity(intent)
            }
            R.id.account -> {
                var intent = Intent(this@TeamActivity, AccountActivity::class.java)
                startActivity(intent)
            }
            R.id.team -> {
                Toast.makeText(this@TeamActivity, "You're already here", Toast.LENGTH_SHORT).show()
            }

        }
        return true
    }
}