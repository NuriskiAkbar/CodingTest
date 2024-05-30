package com.rhiquest.mohnuriskiakbar_codingtestapp.retrofit

import com.rhiquest.mohnuriskiakbar_codingtestapp.response.ResponseGetAllItem
import com.rhiquest.mohnuriskiakbar_codingtestapp.response.ResponseGetAllItemItem
import com.rhiquest.mohnuriskiakbar_codingtestapp.response.ResponseGetItemDetail
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Interface {


    @GET("https://jsonplaceholder.typicode.com/todos")
    fun getAllItem(): Call<ResponseGetAllItemItem>

    @GET("https://jsonplaceholder.typicode.com/todos")
    fun getItemDetail(
        @Query("id") id : Int
    ): Call<ResponseGetItemDetail>
}