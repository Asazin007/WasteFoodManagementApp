package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class JayActivity : AppCompatActivity() {

    // Declarations
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jay)
        //-----------------------DrawerLayout And Navigation View---------------------------------
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        toggle =
            ActionBarDrawerToggle(this@JayActivity, drawerLayout, R.string.Open, R.string.Close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        Interaction with the Drawer Navigation menu items
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.asim -> {
                    var intent = Intent(this@JayActivity, AsimActivity::class.java)
                    startActivity(intent)
                }
                R.id.shoaib -> {
                    var intent = Intent(this@JayActivity, ShoaibActivity::class.java)
                    startActivity(intent)
                }
                R.id.devesh -> {
                    var intent = Intent(this@JayActivity, DeveshActivity::class.java)
                    startActivity(intent)
                }
                R.id.jayveer -> {
                    Toast.makeText(this@JayActivity, "You're already here.", Toast.LENGTH_SHORT).show()
                }
                R.id.ankit -> {
                    var intent = Intent(this@JayActivity, AnkitActivity::class.java)
                    startActivity(intent)
                }
            }
            true
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
                Toast.makeText(this@JayActivity,"You're Home", Toast.LENGTH_SHORT).show()
                var intent = Intent(this@JayActivity, MainActivity2::class.java)
                startActivity(intent)
            }
            R.id.chat -> {
                Toast.makeText(this@JayActivity,"Chats", Toast.LENGTH_SHORT).show()
            }
            R.id.noti -> {
                Toast.makeText(this@JayActivity,"Notifications", Toast.LENGTH_SHORT).show()
            }
            R.id.account -> {
                Toast.makeText(this@JayActivity,"Account details", Toast.LENGTH_SHORT).show()
            }
            R.id.team -> {
                var intent = Intent(this@JayActivity, TeamActivity::class.java)
                startActivity(intent)
            }

        }
        return true
    }
}