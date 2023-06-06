package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetTokenUseCase(private val repository: FoodRepository) {
    fun execute(token: String) = repository.setToken(token)
}