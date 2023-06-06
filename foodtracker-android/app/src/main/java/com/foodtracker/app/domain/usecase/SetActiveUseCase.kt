package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetActiveUseCase(private val repository: FoodRepository) {
    fun execute(active: Int) = repository.setActive(active = active)
}