package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetUserIdUseCase(private val repository: FoodRepository) {
    fun execute(userId: String) = repository.setUserId(userId)
}