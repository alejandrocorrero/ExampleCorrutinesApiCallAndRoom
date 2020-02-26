package com.example.examplecorrutinesapicall.services.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.examplecorrutinesapicall.data.example.Example
import com.example.examplecorrutinesapicall.services.database.daos.ExampleDao

@Database(entities = [Example::class], version = 1)
abstract class DatabaseClient: RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}