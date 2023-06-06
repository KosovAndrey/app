package com.foodtracker.app.presentation.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.foodtracker.app.R
import com.foodtracker.app.domain.model.ProductItem

class ProductsAdapter : ListAdapter<ProductItem, ProductViewHolder>(ProductItemDiffCallback()) {

    var onProductItemLongClickListener: ((ProductItem) -> Unit)? = null
    var onProductItemClickListener: ((ProductItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_DEFAULT -> R.layout.item_product
            VIEW_TYPE_CUSTOM -> R.layout.item_product_custom
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        viewHolder.view.setOnClickListener {
            onProductItemClickListener?.invoke(product)
        }
        viewHolder.textViewName.text = product.name
        viewHolder.textViewKcal.text = product.kcal.toString()
        viewHolder.textViewProteins.text = product.proteins.toString()
        viewHolder.textViewCarbs.text = product.carbs.toString()
        viewHolder.textViewFats.text = product.fats.toString()

    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.custom) {
            VIEW_TYPE_CUSTOM
        } else {
            VIEW_TYPE_DEFAULT
        }
    }

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    private lateinit var mListener: onItemClickListener

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    companion object {

        const val VIEW_TYPE_DEFAULT = 0
        const val VIEW_TYPE_CUSTOM = 1
        const val MAX_POOL_SIZE = 30
    }
}