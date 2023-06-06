package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetCurrentWeightUseCase(private val repository: FoodRepository) {
    fun execute(currentWeight: Float) = repository.setCurrentWeight(currentWeight = currentWeight)
}