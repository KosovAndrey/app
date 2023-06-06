package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.model.UserCreate
import com.foodtracker.app.domain.repository.FoodRepository

class RegistrationUserUseCase(private val repository: FoodRepository) {
    suspend fun execute(userCreate: UserCreate): String? =
        repository.registrationUserApi(userCreate)?.token
}

 





