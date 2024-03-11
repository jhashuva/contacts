package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddItemActivity : AppCompatActivity() {
    private lateinit var rollNoEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var mobileEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var fatherNameEditText: EditText
    private lateinit var fatherMobileEditText: EditText
    private lateinit var motherNameEditText: EditText
    private lateinit var motherMobileEditText: EditText
    private lateinit var presentAddressEditText: EditText
    private lateinit var permenentAddressEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        rollNoEditText = findViewById(R.id.rollNoEditText)
        nameEditText = findViewById(R.id.nameEditText)
        mobileEditText = findViewById(R.id.mobileEditText)
        emailEditText = findViewById(R.id.emailEditText)
        fatherNameEditText  = findViewById(R.id.fatherNameEditText)
        fatherMobileEditText = findViewById(R.id.fatherMobileEditText)
        motherNameEditText = findViewById(R.id.motherNameEditText)
        motherMobileEditText = findViewById(R.id.motherMobileEditText)
        presentAddressEditText = findViewById(R.id.presentAddressEditText)
        permenentAddressEditText = findViewById(R.id.permenentAddressEditText)



        val saveButton: Button = findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            saveItem()
        }
    }

    private fun saveItem() {
        val rollNo = rollNoEditText.text.toString().trim()
        val name = nameEditText.text.toString().trim()
        val mobile = mobileEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val fatherName = fatherNameEditText.text.toString().trim()
        val fatherMobile = fatherMobileEditText.text.toString().trim()
        val motherName = motherNameEditText.text.toString().trim()
        val motherMobile = motherMobileEditText.text.toString().trim()
        val presentAddress = presentAddressEditText.toString().trim()
        val permenentAddress = permenentAddressEditText.toString().trim()

        if (rollNo.isNotEmpty() && name.isNotEmpty() && mobile.isNotEmpty()) {

            // Create a new item and add it to the RecyclerView
            val newItem = Item(0,rollNo, name, mobile,email, fatherName, fatherMobile, motherName, motherMobile, presentAddress, permenentAddress)
            // Get the database instance
            val db = AppDatabase.getInstance(applicationContext)

            // Insert the item into the database using a Coroutine
            GlobalScope.launch {
                db.itemDao().insert(newItem)
            }
            finish() // Finish the activity and return to the main activity
        } else {
            // Handle empty fields
            Toast.makeText(this, "Please fill all the fields.", Toast.LENGTH_SHORT).show()
        }
    }
}