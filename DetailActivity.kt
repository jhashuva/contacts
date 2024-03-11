package com.example.contacts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Retrieve the item data from the intent extras
        val item = intent.getParcelableExtra<Item>("item_key")

        // Access the views in your activity_detail.xml layout
        val rollNoTextView = findViewById<TextView>(R.id.rollNoTextViewDetail)
        val nameTextView = findViewById<TextView>(R.id.nameTextViewDetail)
        val mobileTextView = findViewById<TextView>(R.id.mobileTextViewDetail)
        val contactImageButton = findViewById<ImageButton>(R.id.studentContact)
        val emailTextView = findViewById<TextView>(R.id.emailTextViewDetail)
        val emailImageButton = findViewById<ImageButton>(R.id.studentEmail)
        val fatherNameTextView = findViewById<TextView>(R.id.fatherNameTextViewDetail)
        val fatherMobileTextView = findViewById<TextView>(R.id.fatherMobileTextViewDetail)
        val fatherContactImageButton = findViewById<ImageButton>(R.id.fatherContact)
        val motherNameTextView = findViewById<TextView>(R.id.motherNameTextViewDetail)
        val motherMobileTextView = findViewById<TextView>(R.id.motherMobileTextViewDetail)
        val motherContactImageButton = findViewById<ImageButton>(R.id.motherContact)
        val presentAddressTextView = findViewById<TextView>(R.id.presentAddressTextViewDetail)
        val permenantAddressTextView = findViewById<TextView>(R.id.permenentAddressTextViewDetail)

        val goBackButton = findViewById<ImageButton>(R.id.goBack)
        // Populate the views with the item data
        rollNoTextView.text = item?.rollNo
        nameTextView.text = item?.name
        mobileTextView.text = item?.mobile
        contactImageButton.setOnClickListener(){
           // finish()
        }
        emailTextView.text = item?.emailId
        emailImageButton.setOnClickListener(){

        }
        fatherNameTextView.text = item?.fatherName
        fatherMobileTextView.text = item?.fatherMobile
        fatherContactImageButton.setOnClickListener(){

        }
        motherNameTextView.text = item?.motherName
        motherMobileTextView.text = item?.motherMobile
        motherContactImageButton.setOnClickListener(){

        }
        presentAddressTextView.text = item?.presentAddress
        permenantAddressTextView.text = item?.permenentAddress

        goBackButton.setOnClickListener(){
            finish()
        }

    }
}