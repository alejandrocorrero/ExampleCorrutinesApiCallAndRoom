package com.example.examplecorrutinesapicall.services.api

import android.app.Application
import android.content.Context
import android.content.Intent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

class ApiClient {
    private val service: ApiService

    init {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        builder.connectTimeout(1, TimeUnit.MINUTES)
        builder.readTimeout(1, TimeUnit.MINUTES)
        val client: OkHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        service = retrofit.create<ApiService>(ApiService::class.java)
    }

    companion object Factory {
        private var ourInstance: ApiClient? = null

        @Synchronized
        fun getInstance(): ApiClient {
            if (ourInstance == null) {
                ourInstance = ApiClient()
            }
            return ourInstance as ApiClient
        }
    }

    fun getService(): ApiService {
        return service
    }
}