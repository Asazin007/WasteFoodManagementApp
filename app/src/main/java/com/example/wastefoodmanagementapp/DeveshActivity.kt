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

class DeveshActivity : AppCompatActivity() {

    // Declarations
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devesh)

        //-----------------------DrawerLayout And Navigation View---------------------------------
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        toggle =
            ActionBarDrawerToggle(this@DeveshActivity, drawerLayout, R.string.Open, R.string.Close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        Interaction with the Drawer Navigation menu items
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.asim -> {
                    var intent = Intent(this@DeveshActivity, AsimActivity::class.java)
                    startActivity(intent)
                }
                R.id.shoaib -> {
                    var intent = Intent(this@DeveshActivity, ShoaibActivity::class.java)
                    startActivity(intent)
                }
                R.id.devesh -> {
                    Toast.makeText(this@DeveshActivity, "You're already here.", Toast.LENGTH_SHORT).show()
                }
                R.id.jayveer -> {
                    var intent = Intent(this@DeveshActivity, JayActivity::class.java)
                    startActivity(intent)
                }
                R.id.ankit -> {
                    var intent = Intent(this@DeveshActivity, AnkitActivity::class.java)
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
                Toast.makeText(this@DeveshActivity,"You're Home", Toast.LENGTH_SHORT).show()
                var intent = Intent(this@DeveshActivity, MainActivity2::class.java)
                startActivity(intent)
            }
            R.id.chat -> {
                Toast.makeText(this@DeveshActivity,"Chats", Toast.LENGTH_SHORT).show()
            }
            R.id.noti -> {
                Toast.makeText(this@DeveshActivity,"Notifications", Toast.LENGTH_SHORT).show()
            }
            R.id.account -> {
                Toast.makeText(this@DeveshActivity,"Account details", Toast.LENGTH_SHORT).show()
            }
            R.id.team -> {
                var intent = Intent(this@DeveshActivity, TeamActivity::class.java)
                startActivity(intent)
            }

        }
        return true
    }
}