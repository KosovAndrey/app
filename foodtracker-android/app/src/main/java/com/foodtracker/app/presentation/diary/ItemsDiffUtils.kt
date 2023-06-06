//package com.foodtracker.app.presentation.diary
//
//import androidx.recyclerview.widget.DiffUtil
//import com.foodtracker.app.domain.model.Item
//
//class ItemsDiffUtils(private val oldList: List<Item>, private val newList: List<Item>) :
//    DiffUtil.Callback() {
//    override fun getOldListSize(): Int = oldList.size
//
//    override fun getNewListSize(): Int = newList.size
//
//    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
//        oldList[oldItemPosition].getItemId() == newList[newItemPosition].getItemId()
//
//    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
//        oldList[oldItemPosition] == newList[newItemPosition]
//}