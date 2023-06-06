package com.foodtracker.app.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "users"
)
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val id: String,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "gender")
    val gender: Boolean,
    @ColumnInfo(name = "birthdate")
    val birthdate: Long,
    @ColumnInfo(name = "height")
    val height: Int,
    @ColumnInfo(name = "active")
    val active: Int,
    @ColumnInfo(name = "current_weight")
    val currentWeight: Double,
    @ColumnInfo(name = "goal_weight")
    val goalWeight: Double,
    @ColumnInfo(name = "password")
    val password: String,
    @ColumnInfo(name = "salt")
    val salt: String,
)