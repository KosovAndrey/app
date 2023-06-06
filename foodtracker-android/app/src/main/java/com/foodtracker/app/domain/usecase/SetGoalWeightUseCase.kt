package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetGoalWeightUseCase(private val repository: FoodRepository) {
    fun execute(goalWeight: Float) = repository.setGoalWeight(goalWeight = goalWeight)
}