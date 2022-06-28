package com.example.wastefoodmanagementapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class NotiActivity : AppCompatActivity() {
    var arrList_fname = arrayOf("Shoaib Majeed Moona", "Devesh Pandey", "Sayed Mohd Asim", "Jayveer Mall", "Ankit kumar")
    lateinit var lstView : ListView
    lateinit var Adapter : ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noti)
        lstView = findViewById(R.id.listView)
        Adapter = ArrayAdapter(this@NotiActivity, android.R.layout.simple_list_item_1, arrList_fname)
        lstView.adapter = Adapter
        lstView.setOnItemClickListener { parent, view, position, id ->
            var sendData = Intent(this@NotiActivity, ContributionActivity::class.java)
            sendData.putExtra("arrList_fname", arrList_fname[position])
            startActivity(sendData)
        }
    }
}