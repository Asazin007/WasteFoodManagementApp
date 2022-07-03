package com.example.wastefoodmanagementapp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.*

class NotiActivity : AppCompatActivity() {
    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val donations: DatabaseReference = database.reference.child("Donations")

    var arrList_donations = ArrayList<donationsModel>()
    lateinit var lstView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noti)

        lstView = findViewById(R.id.listView)

        donations.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                arrList_donations.clear()
                for (eachDonations in snapshot.children) {
                    val donations = eachDonations.getValue(donationsModel::class.java)
                    if (donations != null) {
                        arrList_donations.add(donations)
                    }
                }
                lstView.adapter =
                    NotiAdapter(this@NotiActivity, R.layout.donation_names_row, arrList_donations)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        lstView.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@NotiActivity, ContributionActivity::class.java)
            intent.putExtra("id", arrList_donations[i].id)
            intent.putExtra("name", arrList_donations[i].name)
            intent.putExtra("location", arrList_donations[i].location)
            intent.putExtra("phone", arrList_donations[i].phone)
            intent.putExtra("description", arrList_donations[i].description)
            startActivity(intent)
        }
        lstView.setOnItemLongClickListener { adapterView, view, i, l ->
            var id  = arrList_donations[i].id
            var alert = AlertDialog.Builder(this@NotiActivity)
            alert.setTitle("Do you want to delete?")
            alert.setMessage("Are you sure?")
            alert.setCancelable(false)
            alert.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
                donations.child(id).removeValue().addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@NotiActivity,"Deleted Successfully",Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@NotiActivity,"There was some problem.",Toast.LENGTH_SHORT).show()
                    }

                }
            })
            alert.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()
            })
            alert.create().show()
            true
        }
    }
}