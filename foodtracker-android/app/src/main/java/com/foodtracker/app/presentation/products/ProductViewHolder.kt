package com.foodtracker.app.presentation.products

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.foodtracker.app.R

class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val textViewName = view.findViewById<TextView>(R.id.textViewName)
    val textViewKcal = view.findViewById<TextView>(R.id.textViewKcal)
    val textViewProteins = view.findViewById<TextView>(R.id.textViewProteins)
    val textViewCarbs = view.findViewById<TextView>(R.id.textViewCarbs)
    val textViewFats = view.findViewById<TextView>(R.id.textViewFats)
//    init {
//        view.setOnClickListener {
//            listener.onItemClick(adapterPosition)
//        }
//    }
}
