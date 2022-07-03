package com.example.wastefoodmanagementapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class NotiAdapter(var ctx: Context, var customXml: Int, var donationDetails: ArrayList<donationsModel>):
    ArrayAdapter<donationsModel>(ctx,customXml,donationDetails) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(ctx)
        val view: View = layoutInflater.inflate(customXml, null)
        val txt_name: TextView = view.findViewById(R.id.name_row)
        val txt_number: TextView = view.findViewById(R.id.number_row)
        txt_name.text = donationDetails[position].name
        txt_number.text = donationDetails[position].phone
        return view
    }
}