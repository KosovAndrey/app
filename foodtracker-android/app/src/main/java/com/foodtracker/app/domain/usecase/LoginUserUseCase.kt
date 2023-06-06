package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.model.UserLogin
import com.foodtracker.app.domain.repository.FoodRepository


class LoginUserUseCase(private val repository: FoodRepository) {
    suspend fun execute(userLogin: UserLogin): String? = repository.loginUserApi(userLogin)?.token
}