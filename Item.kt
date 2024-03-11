package com.example.contacts

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "itemz")
@Parcelize
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val rollNo: String,
    val name: String,
    val mobile:String,
    val emailId: String,
    val fatherName:String,
    val fatherMobile:String,
    val motherName:String,
    val motherMobile:String,
    val presentAddress:String,
    val permenentAddress:String,
): Parcelable