package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class GetGoalProteinsUseCase(private val repository: FoodRepository) {
    fun execute() = repository.getGoalProteins()
}