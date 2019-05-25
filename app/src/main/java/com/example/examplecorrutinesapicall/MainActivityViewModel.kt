package com.example.examplecorrutinesapicall

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.examplecorrutinesapicall.data.example.Example
import com.example.examplecorrutinesapicall.repositories.example.ExampleRepository
import com.example.examplecorrutinesapicall.services.api.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {

    private val apiClient = ApiClient.getInstance()
    private val apiService = apiClient.getService()
    private val exampleRepository = ExampleRepository(apiService);
    fun getExample(): LiveData<Example> {
        return exampleRepository.getExampleById(1)
    }
}