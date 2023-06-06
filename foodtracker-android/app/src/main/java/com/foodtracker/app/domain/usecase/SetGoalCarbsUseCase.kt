package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetGoalCarbsUseCase(private val repository: FoodRepository) {
    fun execute(goalCarbs: Float) = repository.setGoalCarbs(goalCarbs = goalCarbs)
}