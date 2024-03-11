package com.example.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter() : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var items: List<Item> = emptyList()


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val optionsMenu: ImageView = itemView.findViewById(R.id.optionsMenu)
        fun bind(currentItem: Item) {
            rollNoTextView.text = currentItem.rollNo
            nameTextView.text = currentItem.name
            mobileTextView.text = currentItem.mobile
            emailTextView.text = currentItem.emailId
            fatherNameTextView.text = currentItem.fatherName
            fatherMobileTextView.text = currentItem.fatherMobile
            motherNameTextView.text = currentItem.motherName
            motherMobileTextView.text = currentItem.motherMobile
            presentAddressTextView.text = currentItem.presentAddress
            permenetAddressTextView.text = currentItem.permenentAddress
            optionsMenu.setOnClickListener {
                // Show the PopupMenu
                showPopupMenu(it)
            }
        }

        private fun showPopupMenu(view: View) {
            val popupMenu = PopupMenu(itemView.context, view)
            popupMenu.menuInflater.inflate(R.menu.item_options_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu_edit -> {
                        // Handle Edit action
                        // You can pass the item ID or any identifier to your edit activity/fragment
                        // Example: launchEditActivity(item.id)
                        true
                    }
                    R.id.menu_delete -> {
                        // Handle Delete action
                        // You can show a confirmation dialog before deleting the item
                        // Example: showDeleteConfirmationDialog(item)
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }
        val rollNoTextView: TextView = itemView.findViewById(R.id.rollNoTextView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val mobileTextView: TextView = itemView.findViewById(R.id.mobileTextView)
        val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        val fatherNameTextView: TextView = itemView.findViewById(R.id.fatherNameTextView)
        val fatherMobileTextView: TextView = itemView.findViewById(R.id.fatherMobileTextView)
        val motherNameTextView: TextView = itemView.findViewById(R.id.motherNameTextView)
        val motherMobileTextView: TextView = itemView.findViewById(R.id.motherMobileTextView)
        val presentAddressTextView: TextView = itemView.findViewById(R.id.presentAddressTextView)
        val permenetAddressTextView: TextView = itemView.findViewById(R.id.permanentAddressTextView)
    }



    fun setItems(newItems: List<Item>){
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        if (holder is ItemViewHolder) {
            holder.bind(item) // Call the bind function to populate the views
        }
    }





    override fun getItemCount() = items.size
}