package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class GetEmailUseCase(private val repository: FoodRepository) {
    fun execute(): String? = repository.getEmail()
}