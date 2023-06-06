package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetGenderUseCase(private val repository: FoodRepository) {
    fun execute(gender: Boolean) = repository.setGender(gender = gender)
}