package com.foodtracker.app.data.local.dao

import androidx.room.*
import com.foodtracker.app.data.local.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: UserEntity)

    @Update
    suspend fun updateUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE user_id := :id")
    fun getById(id: String): UserEntity

    @Query("DELETE FROM users WHERE user_id = :id")
    suspend fun deleteUserById(id: String)
}