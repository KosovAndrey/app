package com.foodtracker.app.domain.model

data class User(
    var id: String,
    var username: String,
    var email: String,
    var gender: Boolean,
    var birthdate: Long,
    var height: Int,
    var active: Int,
    var currentWeight: Double,
    var goalWeight: Double,
    var password: String,
    var salt: String
)