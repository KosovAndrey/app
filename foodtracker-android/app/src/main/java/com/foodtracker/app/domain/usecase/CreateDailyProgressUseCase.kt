package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.model.CreateDailyProgress
import com.foodtracker.app.domain.repository.FoodRepository

class CreateDailyProgressUseCase(private val repository: FoodRepository) {
    suspend fun execute(token: String, createDailyProgress: CreateDailyProgress) =
        repository.createDailyProgressApi(token, createDailyProgress)
}