package com.example.examplecorrutinesapicall.repositories.example

import androidx.lifecycle.LiveData
import com.example.examplecorrutinesapicall.data.example.Example

interface ExampleRepositoryInterface {


      fun getExampleById(id: Int): LiveData<Example?>

}