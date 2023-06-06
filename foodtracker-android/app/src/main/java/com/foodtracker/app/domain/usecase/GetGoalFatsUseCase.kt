package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class GetGoalFatsUseCase(private val repository: FoodRepository) {
    fun execute() = repository.getGoalFats()
}