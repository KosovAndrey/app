package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.model.DailyProgress
import com.foodtracker.app.domain.model.GetDailyProgress
import com.foodtracker.app.domain.repository.FoodRepository

class GetDailyProgressUseCase(private val repository: FoodRepository) {
    suspend fun execute(token: String, userId: String, date: Long): DailyProgress? =
        repository.getDailyProgressApi(token = token, GetDailyProgress(userId = userId, date = date))
}