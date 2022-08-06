package com.example.displayitems.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.displayitems.R
import com.example.displayitems.model.ItemModel

class DisplayAllAdapter(
    private val listOfItem : List<ItemModel>) : RecyclerView.Adapter<DisplayAllAdapter.AllItemViewHolder>()  {

    class AllItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        lateinit var allItem: ItemModel
        val id = itemView.findViewById<TextView>(R.id.all_id) // this hold data on that text
        val name = itemView.findViewById<TextView>(R.id.all_name) // this hold data on that text

        fun bind(allItem: ItemModel) {
            this.allItem = allItem
            id.text = allItem.listId.toString()
            name.text = allItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisplayAllAdapter.AllItemViewHolder {
        val listAll = LayoutInflater.from(parent.context).inflate(R.layout.list_id_name, parent, false)
        return AllItemViewHolder(listAll);
    }

    override fun onBindViewHolder(holder: DisplayAllAdapter.AllItemViewHolder, position: Int) {
        val allItem = listOfItem[position]
        holder.bind(allItem)
    }

    override fun getItemCount(): Int {
        return listOfItem.size
    }
}