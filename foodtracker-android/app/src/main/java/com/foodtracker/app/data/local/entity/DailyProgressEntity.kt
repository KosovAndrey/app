package com.foodtracker.app.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "daily_progresses",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"]
        )
    ]
)
data class DailyProgressEntity(
    @PrimaryKey
    @ColumnInfo(name = "daily_progress_id")
    val id: String,
    @ColumnInfo(name = "user_id")
    val userId: String,
    @ColumnInfo(name = "date")
    val date: Long,
    @ColumnInfo(name = "current_kcal")
    val currentKcal: Int,
    @ColumnInfo(name = "goal_kcal")
    val goalKcal: Int,
    @ColumnInfo(name = "current_proteins")
    val currentProteins: Double,
    @ColumnInfo(name = "goal_proteins")
    val goalProteins: Double,
    @ColumnInfo(name = "current_carbs")
    val currentCarbs: Double,
    @ColumnInfo(name = "goal_carbs")
    val goalCarbs: Double,
    @ColumnInfo(name = "current_fats")
    val currentFats: Double,
    @ColumnInfo(name = "goal_fats")
    val goalFats: Double,
    @ColumnInfo(name = "current_water")
    val currentWater: Double,
    @ColumnInfo(name = "goal_water")
    val goalWater: Double,
)