package com.again

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.dataclasses.Links
import com.demo.dataclasses.Next
import com.demo.dataclasses.Post1
import com.demo.foodwe.R
import kotlinx.android.synthetic.main.custom_row.view.*

val x = Next("","")
val y  = Links(x)
    private var mylist1 = Post1(y,-1,-1, emptyList(),-1)
     private lateinit var mlistener1 : myadapter1.onitemclicklistener
class myadapter1 : RecyclerView.Adapter<myadapter1.myviewholder>() {

    class myviewholder(itemView: View,listener: myadapter1.onitemclicklistener) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                listener.onitemclick(adapterPosition)
            }
        }
    }
    interface onitemclicklistener {
        fun onitemclick(position: Int) {
        }
    }
    fun setonclicklistener(listener : myadapter1.onitemclicklistener){
        mlistener1 =  listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false)
        return  myviewholder(view, mlistener1)

    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.itemView.textView2.text = mylist1.hits[position].recipe.label.toString()
        holder.itemView.textView.text = "${ mylist1.hits[position].recipe.ingredients[0].food} ${mylist1.hits[position].recipe.ingredientLines} "
        holder.itemView.textView5.text = "calories:${mylist1.hits[position].recipe.calories.toInt()}"
        Glide.with(holder.itemView).load(mylist1.hits[position].recipe.image.toString()).circleCrop().into(holder.itemView.imageView)
    }

    override fun getItemCount(): Int {
        return mylist1.hits.size

    }
    fun setupdata(newlist : Post1){
        mylist1 = newlist
        notifyDataSetChanged()
        //notifyDataSetChanged()
    }


}