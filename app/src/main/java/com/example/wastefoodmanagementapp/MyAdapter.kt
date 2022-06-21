package com.example.wastefoodmanagementapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ViewHolder(v:View){
    val ngoname :TextView = v.findViewById(R.id.ngo_name)
    val location :TextView= v.findViewById(R.id.locationtxt)
    var img_loc :ImageView = v.findViewById(R.id.location_img)

}
class MyAdapter (var ctx : Context, var CusIntFile:Int, var detail : ArrayList<Model> ) :
    ArrayAdapter<Model>(ctx,CusIntFile,detail){
    val layoutInf : LayoutInflater = LayoutInflater.from(ctx)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View
        var viewholder: ViewHolder
//        var vh2: holdView
        if(convertView==null){
            view  = layoutInf.inflate(CusIntFile,null)

            viewholder = ViewHolder(view)
            view.tag = viewholder
        }
        else{
            view = convertView

            viewholder = view.tag as ViewHolder


        }
        viewholder.ngoname.text = detail[position].ngoname
        viewholder.location.text= detail[position].location
        viewholder.img_loc.setImageResource(R.drawable.ngo)
        return view
}}