package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetEmailUseCase(private val repository: FoodRepository) {
    fun execute(email: String) = repository.setEmail(email)
}