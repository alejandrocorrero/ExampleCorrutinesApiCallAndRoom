package com.example.examplecorrutinesapicall.data.example

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Example(
    @PrimaryKey
    val id: Int,
    val completed: Boolean,
    val title: String,
    val userId: Int
)