package com.example.contacts

import androidx.lifecycle.LiveData

class ItemRepository(private val itemDao: ItemDao) {
    val allItems: LiveData<List<Item>> = itemDao.getAllItems()

    suspend fun insert(item: Item){
        itemDao.insert(item)
    }

    suspend fun delete(item: Item) {
        itemDao.delete(item)
    }

    suspend fun update(item: Item) {
        itemDao.update(item)
    }


    //Implement other database operations as needed
}