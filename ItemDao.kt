package com.example.contacts

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ItemDao {

    @Insert
    suspend fun insert(item: Item)

    @Query("SELECT * FROM itemz")
    fun getAllItems(): LiveData<List<Item>> // LiveData for automatic updates


    @Delete
    suspend fun delete(item: Item)

    @Update
    suspend fun update(item: Item)

}