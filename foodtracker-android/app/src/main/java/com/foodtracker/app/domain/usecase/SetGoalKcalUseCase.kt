package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetGoalKcalUseCase(private val repository: FoodRepository) {
    fun execute(goalKcal: Int) = repository.setGoalKcal(goalKcal = goalKcal)
}