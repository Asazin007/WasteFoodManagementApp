package com.example.wastefoodmanagementapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaration & Initialization ------------
        val front_logo: ImageView = findViewById(R.id.front_img)

        // Animation Initialization ----------
        val img_anim = AnimationUtils.loadAnimation(this, R.anim.slide_anim);

        front_logo.startAnimation(img_anim)

        // Splash Screen code to stay for 3000 milli sec ( 3 sec )
        Handler().postDelayed(Runnable {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }, 3000)


            }

}