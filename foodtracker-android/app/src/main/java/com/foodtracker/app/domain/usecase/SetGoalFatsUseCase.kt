package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetGoalFatsUseCase(private val repository: FoodRepository) {
    fun execute(goalFats: Float) = repository.setGoalFats(goalFats = goalFats)
}