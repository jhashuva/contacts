package com.example.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private lateinit var itemViewModel: ItemViewModel
    private val items = mutableListOf<Item>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: AnotherItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)


        // Set up the RecyclerView with the ItemAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        itemAdapter = AnotherItemAdapter()
        recyclerView.adapter = itemAdapter


        // itemViewModel = ItemViewModel()

        // Observe the LiveData from the Room database and update the adapter when data changes
        val db = AppDatabase.getInstance(applicationContext)
        db.itemDao().getAllItems().observe(this, Observer { items ->
            items?.let {
                itemAdapter.setItems(it)
            }
        })

        // Add the FloatingActionButton and set its click listener
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            startActivity(Intent(this, AddItemActivity::class.java))

        }

    }

}