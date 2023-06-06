//package com.foodtracker.app.domain.model
//
//data class FoodApi(
//    val id: String,
//    val name: String,
//    val kcal: Int,
//    val proteins: Int,
//    val carbs: Int,
//    val fats: Int,
//    val custom: Boolean?,
//    val isProduct: Boolean?,
//    val isFood: Boolean?,
//    val isMeal: Boolean?,
//    val isAddProduct: Boolean?,
//    val isAddFood: Boolean?,
//    val isAddMeal: Boolean?
//)
//
//sealed class Item {
//    fun getItemId(): String = when(this) {
//        is Product -> this.id
//        is Food -> this.id
//        is Meal -> this.id
//        is AddProduct -> this.id
//        is AddFood -> this.id
//        is AddMeal -> this.id
//    }
//}
//
//data class Product(
//    val id: String,
//    val name: String,
//    val kcal: Int,
//    val proteins: Int,
//    val carbs: Int,
//    val fats: Int,
//    val custom: Boolean,
//    val isProduct: Boolean,
//) : Item()
//
//data class Food(
//    val id: String,
//    val name: String,
//    val kcal: Int,
//    val proteins: Int,
//    val carbs: Int,
//    val fats: Int,
//    val isFood: Boolean,
//) : Item()
//
//data class Meal(
//    val id: String,
//    val name: String,
//    val kcal: Int,
//    val proteins: Int,
//    val carbs: Int,
//    val fats: Int,
//    val isMeal: Boolean,
//) : Item()
//
//data class AddProduct(
//    val id: String,
//    val name: String,
//    val kcal: Int,
//    val proteins: Int,
//    val carbs: Int,
//    val fats: Int,
//    val isAddProduct: Boolean
//) : Item()
//
//data class AddFood(
//    val id: String,
//    val name: String,
//    val kcal: Int,
//    val proteins: Int,
//    val carbs: Int,
//    val fats: Int,
//    val isAddFood: Boolean
//) : Item()
//
//data class AddMeal(
//    val id: String,
//    val name: String,
//    val kcal: Int,
//    val proteins: Int,
//    val carbs: Int,
//    val fats: Int,
//    val isAddMeal: Boolean
//) : Item()
//
