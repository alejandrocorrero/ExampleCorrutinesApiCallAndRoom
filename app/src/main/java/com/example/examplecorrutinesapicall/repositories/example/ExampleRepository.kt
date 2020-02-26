package com.example.examplecorrutinesapicall.repositories.example

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.examplecorrutinesapicall.data.example.Example
import com.example.examplecorrutinesapicall.services.api.ApiService
import com.example.examplecorrutinesapicall.services.database.daos.ExampleDao

class ExampleRepository(private val apiService: ApiService, private val database: ExampleDao) :
    ExampleRepositoryInterface {
    override fun getExampleById(id: Int): LiveData<Example?> = liveData {
        emitSource(database.getExample(1))
        val example = apiService.getExample(1)
        database.insertExample(example.body()!!)
    }
}
