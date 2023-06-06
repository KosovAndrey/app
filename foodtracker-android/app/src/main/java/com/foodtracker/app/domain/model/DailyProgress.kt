package com.foodtracker.app.domain.model

data class DailyProgress (
    val id: String,
    val userId: String,
    val date: Long,
    val currentKcal: Int,
    val goalKcal: Int,
    val currentProteins: Double,
    val goalProteins: Double,
    val currentCarbs: Double,
    val goalCarbs: Double,
    val currentFats: Double,
    val goalFats: Double,
    val currentWater: Double,
    val goalWater: Double,
//    val meals: List<Meal>,
//    val breakfast: Meal,
//    val lunch: Meal,
//    val dinner: Meal,
//    val snack: Meal
)