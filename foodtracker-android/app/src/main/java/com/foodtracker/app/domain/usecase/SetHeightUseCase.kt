package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetHeightUseCase(private val repository: FoodRepository) {
    fun execute(height: Int) = repository.setHeight(height = height)
}