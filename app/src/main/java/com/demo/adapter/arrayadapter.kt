package com.demo.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.demo.foodwe.R

class arrayadapter1(private val context: Activity, private val title: Array<String>,private  val c :Array<Int>)
    : ArrayAdapter<String>(context, R.layout.custom_row2, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_row2, null, true)

        val titleText = rowView.findViewById(R.id.textView10) as TextView
        titleText.text = title[position]
         val image  = rowView.findViewById(R.id.imageView3) as ImageView
        image.setImageResource(c[position])
        return rowView
    }
}