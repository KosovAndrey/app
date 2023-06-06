package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetNameUseCase(private val repository: FoodRepository) {
    fun execute(name: String) = repository.setName(name = name)
}