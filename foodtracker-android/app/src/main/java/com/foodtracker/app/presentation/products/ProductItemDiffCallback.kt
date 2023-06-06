package com.foodtracker.app.presentation.products

import androidx.recyclerview.widget.DiffUtil
import com.foodtracker.app.domain.model.ProductItem

class ProductItemDiffCallback : DiffUtil.ItemCallback<ProductItem>() {

    override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem == newItem
    }
}
