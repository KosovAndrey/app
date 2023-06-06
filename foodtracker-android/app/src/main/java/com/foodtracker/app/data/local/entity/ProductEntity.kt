package com.foodtracker.app.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "products"
)
data class ProductEntity(
    @PrimaryKey
    @ColumnInfo(name = "product_id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "kcal")
    val kcal: Int,
    @ColumnInfo(name = "proteins")
    val proteins: Double,
    @ColumnInfo(name = "carbs")
    val carbs: Double,
    @ColumnInfo(name = "fats")
    val fats: Double,
    @ColumnInfo(name = "custom", defaultValue = "1")
    val custom: Boolean
)