package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class GetActiveUseCase(private val repository: FoodRepository) {
    fun execute() = repository.getActive()
}