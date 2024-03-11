package com.example.contacts

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CollapsedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleTextView: TextView = itemView.findViewById(R.id.rollNoTextView)
    val dateTextView: TextView = itemView.findViewById(R.id.nameTextView)
}