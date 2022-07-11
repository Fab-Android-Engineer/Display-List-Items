package com.example.displayitems.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.displayitems.R
import com.example.displayitems.model.ItemModel

class ItemsAdapter (
    private val listOfItem : List<ItemModel>,
    private val isName : Boolean

    ) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>()  {

    class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        lateinit var listItem: ItemModel
        val itemId = itemView.findViewById<TextView>(R.id.item_id) // this hold data on that text

        fun bind(listItem : ItemModel, isName : Boolean) {
            this.listItem = listItem
            if(isName) { // check the data sent from the fragment to the adapter
                itemId.text = listItem.name
            } else {
                itemId.text = listItem.listId.toString()
            }
        }
    }
    // responsible of creating a view to display
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val listItem = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return ItemViewHolder(listItem);
    }
    // responsible for populating a given holder with data from the given position
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val items = listOfItem[position]
        holder.bind(items, isName)
    }
    // return the number of item in the list of ItemModel to answer the recycler view
    override fun getItemCount(): Int {
        return listOfItem.size
    }
}
