package com.demo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class sharedviewmodel : ViewModel() {
    private var pos1 = MutableLiveData<Int>(0)
    val way : LiveData<Int> = pos1
    fun savepos(wr : Int){

        pos1.value = wr
    }
}