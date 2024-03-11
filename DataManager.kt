package com.example.contacts

object DataManager {
    private val items = mutableListOf<Item>()

    fun getItems(): List<Item> {
        return items
    }

    fun addItem(item: Item) {
        items.add(item)
    }
}