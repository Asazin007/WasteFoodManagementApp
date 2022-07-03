package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class My_Donate : AppCompatActivity() {
    //    Firebase Declarations by Shoaib
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val donations: DatabaseReference = database.reference.child("Donations")

    //    Navgation Declaration by Asim widgets declarations by Shoaib
    lateinit var BottomNavigationView: BottomNavigationView
    lateinit var edtName: EditText
    lateinit var edtlocation: EditText
    lateinit var edtTextPhone: EditText
    lateinit var edtDescrip: EditText
    lateinit var btnSubmit: Button
    lateinit var name: String
    lateinit var location: String
    lateinit var phone: String
    lateinit var description: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_donate)

//  Initialization of widgets
        BottomNavigationView = findViewById(R.id.bottom_navigation)
        edtName = findViewById(R.id.edtName)
        edtlocation = findViewById(R.id.edtlocation)
        edtTextPhone = findViewById(R.id.editTextPhone)
        edtDescrip = findViewById(R.id.edtDescrip)
        btnSubmit = findViewById(R.id.btnDonateSubmit)

        BottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.team -> {
                    var team_intent = Intent(this, TeamActivity::class.java)
                    startActivity(team_intent)
                }
                R.id.home_menu -> {
                    var home_intent = Intent(this, MainActivity2::class.java)
                    startActivity(home_intent)
                }
                R.id.noti -> {
                    var intent = Intent(this, NotiActivity::class.java)
                    startActivity(intent)
                }
                R.id.account -> {
                    var intent = Intent(this, AccountActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }
//        Buttom Submit Action
        btnSubmit.setOnClickListener {
            name = edtName.text.toString()
            location = edtlocation.text.toString()
            phone = edtTextPhone.text.toString()
            description = edtDescrip.text.toString()

//            Inserting data in the Firebase table [donations]
            val token: String = donations.push().key.toString()
           if (name != "" && location != "" && phone != "" && description != ""){
               val model = donationsModel(token, name, location, phone, description)
               donations.child(token).setValue(model).addOnCompleteListener { checkData ->
                   if (checkData.isSuccessful) {
                       Toast.makeText(this, "Thanks for Donating", Toast.LENGTH_SHORT).show()
                   } else {
                       Toast.makeText(
                           this,
                           "There was some problem while submitting",
                           Toast.LENGTH_SHORT
                       ).show()
                   }
               }

//            Clearing text in widgets
               edtName.setText("")
               edtlocation.setText("")
               edtTextPhone.setText("")
               edtDescrip.setText("")

               edtName.requestFocus()
           } else {
               Toast.makeText(this@My_Donate, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
           }
        }
    }

}