package com.example.contacts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ItemViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ItemRepository
    val allItems: LiveData<List<Item>>

    init {
        val itemDao = AppDatabase.getInstance(application).itemDao()
        repository = ItemRepository(itemDao)
        allItems = repository.allItems
    }
    fun insert(item: Item) = viewModelScope.launch {
        repository.insert(item)
    }

    // Add other methods to perform database operations
}