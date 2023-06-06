package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.repository.FoodRepository

class SetBirthdayUseCase(private val repository: FoodRepository) {
    fun execute(birthday: Long) = repository.setBirthday(birthday = birthday)
}