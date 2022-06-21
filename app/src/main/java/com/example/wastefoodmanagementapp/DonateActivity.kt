package com.example.wastefoodmanagementapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView

class DonateActivity : AppCompatActivity() {
    lateinit var lstview :ListView
    lateinit var ngoname :String
    lateinit var location:String
     var img_donate : Int = 0
    var donatebox = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate)
        lstview= findViewById(R.id.donate_lst_view)
        for (i in 1..5){
            ngoname="THE AKSHAY PATRA FOUNDATION"
            location="Phagwada, Punjab"
            img_donate = R.drawable.foodwaste
            donatebox.add(Model(ngoname,location,img_donate))
        }
        lstview.adapter= MyAdapter(this@DonateActivity,R.layout.row,donatebox)

    }
}