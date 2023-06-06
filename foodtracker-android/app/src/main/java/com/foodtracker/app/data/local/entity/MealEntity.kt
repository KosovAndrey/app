package com.foodtracker.app.data.local.entity

import androidx.room.*

@Entity(
    tableName = "meals",
    foreignKeys = [
        ForeignKey(
            entity = DailyProgressEntity::class,
            parentColumns = ["daily_progress_id"],
            childColumns = ["daily_progress_id"]
        )
    ]
)
data class MealEntity(
    @PrimaryKey
    @ColumnInfo(name = "meal_id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "daily_progress_id")
    val dailyProgressId: String,
    @ColumnInfo(name = "kcal")
    val kcal: Int,
    @ColumnInfo(name = "proteins")
    val proteins: Double,
    @ColumnInfo(name = "carbs")
    val carbs: Double,
    @ColumnInfo(name = "fats")
    val fats: Double,
    @Relation(
        parentColumn = "meal_id",
        entity = ProductEntity::class,
        entityColumn = "product_id",
        associateBy = Junction(ProductMealCrossRef::class)
    )
    val products: List<ProductEntity>,
)