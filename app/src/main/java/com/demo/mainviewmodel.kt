package com.demo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.dataclasses.Post1
import com.demo.dataclasses.Recipe
import com.repository.repository
import kotlinx.coroutines.launch
import retrofit2.Response

class mainviewmodel(private val repository: repository):ViewModel()
{
    val myresponce :MutableLiveData<Response<Post1>> = MutableLiveData()
    val myresponce2 :MutableLiveData<Response<Recipe>> = MutableLiveData()
    fun getpost(type : String,query:String,appid : String,appkey:String){
        viewModelScope.launch {
            val responce = repository.getpost(type,query,appid,appkey)
               myresponce.value = responce
        }
    }
 /*   fun getpost2(type : String,query:String,appid : String,appkey:String,ingr:String){
        viewModelScope.launch{
            val response:Response<Recipe> = repository.getpost2(type,query,appid,appkey,ingr )
            myresponce2.value = response
        }
    }*/
}