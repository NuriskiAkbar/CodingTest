package com.rhiquest.mohnuriskiakbar_codingtestapp.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/todos/"
        private var retrofit: Retrofit? = null
        fun getInstance() : Retrofit{

            val gson = GsonBuilder()
                .setLenient()
                .create()

            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit!!
        }
    }
}