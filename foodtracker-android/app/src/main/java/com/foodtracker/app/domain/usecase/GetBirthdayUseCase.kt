package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class GetBirthdayUseCase(private val repository: FoodRepository) {
    fun execute() = repository.getBirthday()
}