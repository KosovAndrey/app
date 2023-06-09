package com.foodtracker.app.presentation.diary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.foodtracker.app.R
import com.foodtracker.app.domain.model.ProductItem

class ItemAdapter2(mList: List<DataModel>) :
    RecyclerView.Adapter<ItemAdapter2.ItemViewHolder>() {
    private val mList: List<DataModel>
    private var list: List<String> = ArrayList()
    var onAddProductClickListener: ((DataModel) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val model: DataModel = mList[position]
        holder.mTextView.setText(model.getItemText())
        val isExpandable: Boolean = model.isExpandable()
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE
        if (isExpandable) {
            holder.mArrowImage.setImageResource(R.drawable.ic_arrow_up)
        } else {
            holder.mArrowImage.setImageResource(R.drawable.ic_arrow_down)
        }
        val adapter = NestedAdapter(list)
        holder.nestedRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.nestedRecyclerView.setHasFixedSize(true)
        holder.nestedRecyclerView.adapter = adapter
        holder.linearLayout.setOnClickListener {
            model.setExpandable(!model.isExpandable())
            list = model.getNestedList()
            notifyItemChanged(holder.adapterPosition)
        }
        holder.imageViewAdd.setOnClickListener {
            onAddProductClickListener?.invoke(model)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val linearLayout: LinearLayout
        val expandableLayout: RelativeLayout
        val mTextView: TextView
        val mArrowImage: ImageView
        val nestedRecyclerView: RecyclerView
        val imageViewAdd: ImageView

        init {
            linearLayout = itemView.findViewById(R.id.linear_layout)
            expandableLayout = itemView.findViewById(R.id.expandable_layout)
            mTextView = itemView.findViewById(R.id.itemTv)
            mArrowImage = itemView.findViewById(R.id.arro_imageview)
            nestedRecyclerView = itemView.findViewById(R.id.child_rv)
            imageViewAdd = itemView.findViewById(R.id.imageViewAdd)
        }
    }

    init {
        this.mList = mList
    }
}

//[
//    day {
//        id: String,
//        data: Strin
//    },
//day {
//    id: String,
//    data: Strin
//}
//]