package com.demo.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.dataclasses.*
import com.demo.foodwe.R
import kotlinx.android.synthetic.main.custom_row.view.*

val x = Next("","")
             val y  = Links(x)
       private var mylist = Post1(y,-1,-1, emptyList(),-1)
      private lateinit var mlistener : myadapter.onitemclicklistener
class myadapter() : RecyclerView.Adapter<myadapter.myviewholder>() {
    class myviewholder(itemView: View,listener: onitemclicklistener) : RecyclerView.ViewHolder(itemView){
      init {
              itemView.setOnClickListener {
                   listener.onitemclick(adapterPosition)
            }
      }
    }
    interface onitemclicklistener{
        fun onitemclick(position: Int) {
        }
    }
    fun setonclicklistener(listener : onitemclicklistener){
        mlistener =  listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false)
        return  myviewholder(view, mlistener)

    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.itemView.textView2.text = mylist.hits[position].recipe.label.toString()
         holder.itemView.textView.text = "${ mylist.hits[position].recipe.ingredients[0].food} ${mylist.hits[position].recipe.ingredients[1].food}  ${mylist.hits[position].recipe.ingredientLines} "
        holder.itemView.textView5.text = "calories:${mylist.hits[position].recipe.calories.toInt()}"
        Glide.with(holder.itemView).load(mylist.hits[position].recipe.image.toString()).circleCrop().into(holder.itemView.imageView)

    }

    override fun getItemCount(): Int {
        return mylist.hits.size


    }
    fun setupdata(newlist : Post1){
        mylist = newlist
        notifyDataSetChanged()
        //notifyDataSetChanged()
    }



}
