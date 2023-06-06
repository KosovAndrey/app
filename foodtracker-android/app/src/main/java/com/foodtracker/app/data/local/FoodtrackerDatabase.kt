package com.foodtracker.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.foodtracker.app.data.local.dao.DailyProgressDao
import com.foodtracker.app.data.local.dao.MealDao
import com.foodtracker.app.data.local.dao.ProductDao
import com.foodtracker.app.data.local.dao.UserDao
import com.foodtracker.app.data.local.entity.*

@Database(
    version = 1,
    entities = [
        UserEntity::class,
        DailyProgressEntity::class,
        MealEntity::class,
        ProductMealCrossRef::class,
        ProductEntity::class
    ]
)
abstract class FoodtrackerDatabase : RoomDatabase() {
    abstract fun users(): UserDao
    abstract fun dailyProgresses(): DailyProgressDao
    abstract fun meals(): MealDao
    abstract fun products(): ProductDao
}