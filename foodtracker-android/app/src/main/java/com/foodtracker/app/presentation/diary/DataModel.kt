package com.foodtracker.app.presentation.diary

class DataModel(itemList: List<String>, itemText: String) {

    private var nestedList: List<String> = itemList
    private var itemText: String = itemText
    private var isExpandable = false

//    fun DataModel(itemList: List<String>?, itemText: String?) {
//        nestedList = itemList
//        this.itemText = itemText
//        isExpandable = false
//    }

    fun setExpandable(expandable: Boolean) {
        isExpandable = expandable
    }

    fun getNestedList(): List<String> {
        return nestedList
    }

    fun getItemText(): String {
        return itemText
    }

    fun isExpandable(): Boolean {
        return isExpandable
    }
}
