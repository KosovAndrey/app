package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class GetHeightUseCase(private val repository: FoodRepository) {
    fun execute() = repository.getHeight()
}