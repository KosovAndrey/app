package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.model.User
import com.foodtracker.app.domain.repository.FoodRepository

class UpdateUserUseCase(private val repository: FoodRepository) {
    suspend fun execute(token: String, user: User) =
        repository.updateUserApi(token = token, user)
}