package com.example.examplecorrutinesapicall

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.room.Room
import com.example.examplecorrutinesapicall.data.example.Example
import com.example.examplecorrutinesapicall.repositories.example.ExampleRepository
import com.example.examplecorrutinesapicall.services.api.ApiClient
import com.example.examplecorrutinesapicall.services.database.DatabaseClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val apiClient = ApiClient.getInstance()
    private val apiService = apiClient.getService()
    private val databaseClient = Room.databaseBuilder(application, DatabaseClient::class.java, "database").build()
    private val exampleRepository = ExampleRepository(apiService, databaseClient.exampleDao());
    fun getExample(): LiveData<Example?> {
        return exampleRepository.getExampleById(1)
    }
}