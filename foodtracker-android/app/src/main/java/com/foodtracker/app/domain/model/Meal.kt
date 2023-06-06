package com.foodtracker.app.domain.model

data class Meal(
    val id: String,
    val name: String,
    val kcal: String,
    val proteins: String,
    val carbs: String,
    val fats: String,
    val list: List<ProductItem>
)