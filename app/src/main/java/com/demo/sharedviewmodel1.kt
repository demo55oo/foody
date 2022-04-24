package com.demo

import androidx.lifecycle.ViewModel
import com.demo.dataclasses.Links
import com.demo.dataclasses.Next
import com.demo.dataclasses.Post1
val x = Next("","")
val y  = Links(x)
class sharedviewmodel1 : ViewModel() {
    val x = Next("","")
    val y  = Links(x)
    private var data = Post1(y,-1,-1, emptyList(),-1)
    val detail  = data
    fun setdetails(alldata:Post1){
        data = alldata

    }
}