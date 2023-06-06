package com.foodtracker.app.domain.repository

import com.foodtracker.app.domain.model.*

interface FoodRepository {

    suspend fun loginUserApi(userLogin: UserLogin): Token?

    suspend fun registrationUserApi(userCreate: UserCreate): Token?

    suspend fun getUserApi(token: String, getUser: GetUser): User?

    suspend fun updateUserApi(token: String, user: User)

    suspend fun updatePasswordApi(token: String, user: User)

    suspend fun getProductsApi(token: String): List<ProductItem?>?

    suspend fun getProductApi(token: String, id: String): ProductItem?

    suspend fun getDailyProgressApi(token: String, getDailyProgress: GetDailyProgress): DailyProgress?

    suspend fun createDailyProgressApi(token: String, createDailyProgress: CreateDailyProgress)

    fun getToken(): String?

    fun setToken(token: String)

    fun getUserId(): String?

    fun setUserId(userId: String)

    fun getEmail(): String

    fun setEmail(email: String)

    fun getName(): String

    fun setName(name: String)

    fun getGender(): Boolean

    fun setGender(gender: Boolean)

    fun getBirthday(): Long

    fun setBirthday(birthday: Long)

    fun getHeight(): Int

    fun setHeight(height: Int)

    fun getActive(): Int

    fun setActive(active: Int)

    fun getCurrentWeight(): Float

    fun setCurrentWeight(currentWeight: Float)

    fun getGoalWeight(): Float

    fun setGoalWeight(goalWeight: Float)

    fun getGoalKcal(): Int

    fun setGoalKcal(goalKcal: Int)

    fun getGoalProteins(): Float

    fun setGoalProteins(goalProteins: Float)

    fun getGoalCarbs(): Float

    fun setGoalCarbs(goalCarbs: Float)

    fun getGoalFats(): Float

    fun setGoalFats(goalFats: Float)

    fun clearPreference(): Boolean
}