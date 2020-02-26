package com.example.examplecorrutinesapicall.services.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.examplecorrutinesapicall.data.example.Example

@Dao
interface ExampleDao {
    @Query("SELECT * FROM example where id = :idexample")
     fun getExample(idexample: Int): LiveData<Example?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExample(examples: Example)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExamples(examples:List<Example>)

    @Transaction
     fun testTransactionExample():Example?{
        val test = getExample(1)
        //AQUI SE HARIA OTRA OPERACIÓN COMO ELIMINAR DICHO EJEMPLO, OBETENER OTROS O CUALQUEIR OPERACIÓN


        // Aqui se devolveria por ejemplo el objeto eliminado despues de las operaciones
        return test.value
    }
}