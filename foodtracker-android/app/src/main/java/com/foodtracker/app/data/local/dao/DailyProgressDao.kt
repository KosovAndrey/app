package com.foodtracker.app.data.local.dao

import androidx.room.*
import com.foodtracker.app.data.local.entity.DailyProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyProgressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDailyProgress(dailyProgress: DailyProgressEntity)

    @Update
    suspend fun updateDailyProgress(dailyProgress: DailyProgressEntity)

    @Delete
    suspend fun deleteDailyProgress(dailyProgress: DailyProgressEntity)

    @Query("SELECT * FROM daily_progresses WHERE user_id == :userId ORDER BY date ASC")
    fun getAllDailyProgresses(userId: String): List<DailyProgressEntity>

    @Query("SELECT * FROM daily_progresses WHERE user_id == :userId ORDER BY date ASC")
    fun observeAllDailyProgresses(userId: String): Flow<List<DailyProgressEntity>>

    @Query("SELECT * FROM daily_progress WHERE daily_progress_id == :id")
    fun getDailyProgress(id: String): DailyProgressEntity
}