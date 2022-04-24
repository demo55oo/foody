package com.demo.api

import com.demo.dataclasses.Post1
import com.demo.dataclasses.Recipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface mainapi {
    @GET("/api/recipes/v2")
    suspend fun getpost(
        @Query("type") q: String,
        @Query("q") Search: String,
        @Query("app_id") app_id:String,
        @Query("app_key") appkey: String)
      :Response<Post1>

    @GET("/api/recipes/v2")
    suspend fun getppost2(
        @Query("type") q: String,
        @Query("q") Search: String,
        @Query("app_id") app_id:String,
        @Query("app_key") appkey: String,
        @Query("ingr") ingr: String):Response<Recipe>
}
