package com.example.contacts

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EditItemActivity : AppCompatActivity() {
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
        setContentView(R.layout.activity_edit_item)
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


        val updateButton: Button = findViewById(R.id.saveButton)

        val item = intent.getParcelableExtra<Item>("item_key")
        rollNoEditText.setText(item?.rollNo)
        nameEditText.setText(item?.name)
        mobileEditText.setText(item?.mobile)
        emailEditText.setText(item?.emailId)
        fatherNameEditText.setText(item?.fatherName)
        fatherMobileEditText.setText(item?.fatherMobile)
        motherNameEditText.setText(item?.motherName)
        motherMobileEditText.setText(item?.motherMobile)
        presentAddressEditText.setText(item?.presentAddress)
        permenentAddressEditText.setText(item?.permenentAddress)


        updateButton.setOnClickListener {
            updateItem(item)
        }
    }

    private fun updateItem(item: Item?) {
        val rollNo = rollNoEditText.text.toString().trim()
        val name = nameEditText.text.toString().trim()
        val mobile = mobileEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()
        val fatherName = fatherNameEditText.text.toString().trim()
        val fatherMobile = fatherMobileEditText.text.toString().trim()
        val motherName = motherNameEditText.text.toString().trim()
        val motherMobile = motherMobileEditText.toString().trim()
        val presentAddress = presentAddressEditText.toString().trim()
        val permenentAddress = permenentAddressEditText.toString().trim()

        if (rollNo.isNotEmpty() && name.isNotEmpty() && mobile.isNotEmpty()) {
            // Create a new item and add it to the RecyclerView
            val newItem = Item(item!!.id,name, rollNo, mobile,email,fatherName, fatherMobile, motherName, motherMobile, presentAddress, permenentAddress)
            // Get the database instance
            val db = AppDatabase.getInstance(applicationContext)

            // Insert the item into the database using a Coroutine
            GlobalScope.launch {
                try {
                    db.itemDao().update(newItem)
                    finish() // Finish the activity and return to the main activity
                } catch (e:java.lang.Exception){
                    Log.e(ContentValues.TAG, "Error updating item: ${e.message}", e)
                }

            }

        } else {
            // Handle empty fields
            Toast.makeText(this, "Please fill all the fields.", Toast.LENGTH_SHORT).show()
        }

    }
}