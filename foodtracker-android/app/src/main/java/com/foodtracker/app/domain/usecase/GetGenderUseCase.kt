package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class GetGenderUseCase(private val repository: FoodRepository) {
    fun execute() = repository.getGender()
}