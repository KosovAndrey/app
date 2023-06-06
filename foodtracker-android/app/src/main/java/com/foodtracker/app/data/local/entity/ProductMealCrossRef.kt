package com.foodtracker.app.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "product_meal",
    primaryKeys = ["meal_id", "product_id"],
    foreignKeys = [
        ForeignKey(
            entity = MealEntity::class,
            parentColumns = ["meal_id"],
            childColumns = ["meal_id"]
        ),
        ForeignKey(
            entity = ProductEntity::class,
            parentColumns = ["product_id"],
            childColumns = ["product_id"]
        )
    ]
)
data class ProductMealCrossRef(
    @ColumnInfo(name = "meal_id")
    val mealId: String,
    @ColumnInfo(name = "product_id")
    val productId: String,
)