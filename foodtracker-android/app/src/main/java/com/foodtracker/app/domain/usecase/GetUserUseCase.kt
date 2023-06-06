package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.model.GetUser
import com.foodtracker.app.domain.model.User
import com.foodtracker.app.domain.repository.FoodRepository

class GetUserUseCase(private val repository: FoodRepository) {
    suspend fun execute(token: String, userId: String): User? =
        repository.getUserApi(token = token, GetUser(id = userId))
}