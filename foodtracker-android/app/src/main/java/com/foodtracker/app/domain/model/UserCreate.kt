package com.foodtracker.app.domain.model

data class UserCreate (
    val username: String,
    val email: String,
    val gender: Boolean,
    val birthdate: Long,
    val height: Int,
    val active: Int,
    val currentWeight: Float,
    val goalWeight: Float,
    val password: String
)




