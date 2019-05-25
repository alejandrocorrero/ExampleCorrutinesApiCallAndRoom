package com.example.examplecorrutinesapicall.services.api

import androidx.lifecycle.LiveData
import com.example.examplecorrutinesapicall.data.example.Example
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("todos/{id}")
    suspend fun getExample(@Path("id") id: Int): Response<Example>

}