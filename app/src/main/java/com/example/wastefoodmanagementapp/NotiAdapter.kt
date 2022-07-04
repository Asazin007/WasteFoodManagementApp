package com.example.wastefoodmanagementapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class ViewNotificationHolder(v: View) {
    val txt_name: TextView = v.findViewById(R.id.name_row)
    val txt_number: TextView = v.findViewById(R.id.number_row)
}
class NotiAdapter(var ctx: Context, var customXml: Int, var donationDetails: ArrayList<donationsModel>):
    ArrayAdapter<donationsModel>(ctx,customXml,donationDetails) {
        val layoutInflater: LayoutInflater = LayoutInflater.from(ctx)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewNotiHolder: ViewNotificationHolder
        if (convertView == null) {
           view = layoutInflater.inflate(customXml, null)
            viewNotiHolder = ViewNotificationHolder(view)
            view.tag = viewNotiHolder
        } else {
            view = convertView
            viewNotiHolder = view.tag as ViewNotificationHolder
        }
        viewNotiHolder.txt_name.text = donationDetails[position].name
        viewNotiHolder.txt_number.text = donationDetails[position].phone
        return view
    }
}