package com.foodtracker.app.domain.usecase

import com.foodtracker.app.domain.model.ProductItem
import com.foodtracker.app.domain.repository.FoodRepository

class GetProductUseCase(private val repository: FoodRepository) {
    suspend fun execute(token: String, id: String): ProductItem? = repository.getProductApi(token, id)

}