package com.example.wishlist

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter (private val numItems: List<WishList>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val name: TextView
        val price: TextView
        val description: TextView
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            name = itemView.findViewById(R.id.senderTv)
            price = itemView.findViewById(R.id.titleTv)
            description = itemView.findViewById(R.id.summaryTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = numItems.get(position)
        // Set item views based on views and data model
        holder.name.text = item.name
        holder.price.text = item.price
        holder.description.text = item.description
    }

    override fun getItemCount(): Int {
        return numItems.size
    }
}