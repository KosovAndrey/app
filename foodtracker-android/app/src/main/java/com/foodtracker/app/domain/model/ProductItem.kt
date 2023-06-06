package com.foodtracker.app.domain.model

data class ProductItem(
    val id: String,
    val name: String,
    val kcal: Int,
    val proteins: Double,
    val carbs: Double,
    val fats: Double,
    val custom: Boolean
)