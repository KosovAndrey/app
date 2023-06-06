package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetGoalProteinsUseCase(private val repository: FoodRepository) {
    fun execute(goalProteins: Float) = repository.setGoalProteins(goalProteins = goalProteins)
}