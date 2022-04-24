package com.repository

import com.demo.dataclasses.Post1
import com.demo.dataclasses.Recipe
import com.demo.retrofitinstance
import retrofit2.Response

class repository {
    suspend fun getpost(type : String,query:String,appid : String,appkey:String):Response<Post1>{
        return retrofitinstance.api.getpost(type,query,appid,appkey)
    }
    suspend fun getpost2(type : String,query:String,appid : String,appkey:String,ingr:String):Response<Recipe>{
        return retrofitinstance.api.getppost2(type,query,appid,appkey,ingr)
    }
}