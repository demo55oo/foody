package com.again

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class sharedsearch2:ViewModel() {
    private var pos2 = MutableLiveData<String>("")
    val way : LiveData<String> = pos2
    fun savepos1(wr : String){

        pos2.value = wr
    }
}