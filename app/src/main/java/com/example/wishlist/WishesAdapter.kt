package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Create the basic adapter extending from Recyclerview.Adapter
// Note that we specify the custom viewHolder which gives us access to our views
class WishesAdapter(private val wishes: List<Wish>): RecyclerView.Adapter<WishesAdapter.ViewHolder>() {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val tvName: TextView
        val tvLink: TextView
        val tvPrice: TextView

        init {
            tvName = itemView.findViewById<TextView>(R.id.tvName)
            tvLink = itemView.findViewById<TextView>(R.id.tvLink)
            tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish = wishes.get(position)
        holder.tvName.text = wish.name
        holder.tvPrice.text = wish.price.toString()
        holder.tvLink.text =  wish.link
    }

    override fun getItemCount(): Int {
        return wishes.size
    }
}