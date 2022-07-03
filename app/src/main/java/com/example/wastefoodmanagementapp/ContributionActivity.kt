package com.example.wastefoodmanagementapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.wastefoodmanagementapp.databinding.ActivityContributionBinding
import org.w3c.dom.Text

class ContributionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContributionBinding

    lateinit var edt_name: TextView
    lateinit var edt_location: TextView
    lateinit var edt_phone: TextView
    lateinit var edt_description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContributionBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        Receiving data from NotiActivity
        val id = intent.getStringExtra("id")
        val name = intent.getStringExtra("name").toString()
        val location = intent.getStringExtra("location").toString()
        val phone = intent.getStringExtra("phone").toString()
        val description = intent.getStringExtra("description").toString()

        edt_name = findViewById(R.id.edt_name)
        edt_location = findViewById(R.id.edt_location)
        edt_phone = findViewById(R.id.edt_phone)
        edt_description = findViewById(R.id.edt_description)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = name

        edt_name.setText(name)
        edt_location.setText(location)
        edt_phone.setText(phone)
        edt_description.setText(description)
        Toast.makeText(this, "ID: ${id}", Toast.LENGTH_SHORT).show()
    }
}