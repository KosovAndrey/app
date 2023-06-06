package com.foodtracker.app.data.local.dao

import androidx.room.*
import com.foodtracker.app.data.local.entity.MealEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMeal(meal: MealEntity)

    @Update
    suspend fun updateMeal(meal: MealEntity)

    @Delete
    suspend fun deleteMeal(meal: MealEntity)

    @Query("SELECT * FROM meals WHERE meal_id := :id")
    fun getById(id: String): MealEntity

    @Query("DELETE FROM meals WHERE meal_id = :id")
    suspend fun deleteMealById(id: String)

    @Query("SELECT * FROM meals WHERE daily_progress_id == :id")
    fun getAllMealsByDailyProgress(id: String): List<MealEntity>

    @Query("SELECT * FROM meals WHERE daily_progress_id == :id")
    fun observeAllMeals(id: String): Flow<List<MealEntity>>
}