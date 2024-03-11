package com.example.contacts

import android.app.AlertDialog
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AnotherItemAdapter() : RecyclerView.Adapter<AnotherItemAdapter.AnotherItemViewHolder>() {
    private var items: List<Item> = emptyList()

    // Other existing code...

    inner class AnotherItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val optionsMenu: ImageView = itemView.findViewById(R.id.optionsMenu)
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(currentItem: Item) {
            rollNoTextView.text = currentItem.rollNo
            nameTextView.text = currentItem.name
            rollNoTextView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                //val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("item_key", currentItem)
                itemView.context.startActivity(intent)
            }
            optionsMenu.setOnClickListener {
                // Show the PopupMenu
                showPopupMenu(it,currentItem)
            }

        }
        @RequiresApi(Build.VERSION_CODES.O)
        private fun showPopupMenu(view: View, currentItem: Item) {
            val popupMenu = PopupMenu(itemView.context, view)
            popupMenu.menuInflater.inflate(R.menu.item_options_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu_edit -> {

                        val intent = Intent(itemView.context, EditItemActivity::class.java)
                        intent.putExtra("item_key",currentItem)
                        itemView.context.startActivity(intent)
                        // Handle Edit action
                        // You can pass the item ID or any identifier to your edit activity/fragment
                        // Example: launchEditActivity(item.id)
                        true
                    }
                    R.id.menu_delete -> {
                        // Handle Delete action
                        // You can show a confirmation dialog before deleting the item
                        showDeleteConfirmationDialog(currentItem)
                        // Example: showDeleteConfirmationDialog(item)
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }

        @RequiresApi(Build.VERSION_CODES.O)
        private fun showDeleteConfirmationDialog(item: Item) {
            val builder = AlertDialog.Builder(itemView.context)
            builder.setMessage("Are you sure you want to delete this item?")
                .setPositiveButton("Delete") { _, _ ->
                    // Call the delete function here
                    val db = AppDatabase.getInstance(itemView.context)
                    GlobalScope.launch{
                        db.itemDao().delete(item)
                    }

                }
                .setNegativeButton("Cancel") { _, _ ->
                    // Do nothing or handle cancellation
                }
            val dialog = builder.create()
            dialog.show()

        }

        val rollNoTextView: TextView = itemView.findViewById(R.id.rollNoTextView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)


    }
    fun setItems(newItems: List<Item>){
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnotherItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_collapsed_layout, parent, false)
        return AnotherItemViewHolder(itemView)
    }

    override fun getItemCount() = items.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: AnotherItemAdapter.AnotherItemViewHolder, position: Int) {
        val item = items[position]
        if(holder is AnotherItemViewHolder){
            holder.bind(item)
        }
    }



}