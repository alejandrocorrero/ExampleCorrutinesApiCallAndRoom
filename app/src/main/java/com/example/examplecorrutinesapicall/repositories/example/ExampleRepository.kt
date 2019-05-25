package com.example.examplecorrutinesapicall.repositories.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.examplecorrutinesapicall.data.example.Example
import com.example.examplecorrutinesapicall.services.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class ExampleRepository(private val apiService: ApiService) : ExampleRepositoryInterface {
    override fun getExampleById(id: Int): LiveData<Example> {
        return liveData(Dispatchers.IO) { emit(apiService.getExample(1).body()!!) }
    }
}
