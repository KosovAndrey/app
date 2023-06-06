package com.foodtracker.app.data.repository

import android.content.Context
import com.foodtracker.app.data.remote.ApiService
import com.foodtracker.app.data.preferences.PreferenceStorage
import com.foodtracker.app.domain.model.*
import com.foodtracker.app.domain.repository.FoodRepository

class FoodRepositoryImpl(context: Context) : FoodRepository {

    private val preferenceStorage = PreferenceStorage(context)

    override suspend fun loginUserApi(userLogin: UserLogin): Token? {
        return ApiService.retrofit.login(userLogin).body()
    }

    override suspend fun registrationUserApi(userCreate: UserCreate): Token? {
        return ApiService.retrofit.registration(userCreate).body()
    }

    override suspend fun getUserApi(
        token: String,
        getUser: GetUser
    ): User? {
        return ApiService.retrofit.getUserById("Bearer $token", getUser).body()
    }

    override suspend fun updateUserApi(token: String, user: User) {
        return ApiService.retrofit.updateUser("Bearer $token", user)
    }

    override suspend fun updatePasswordApi(token: String, user: User) {
        return ApiService.retrofit.updatePassword("Bearer $token", user)
    }

    override suspend fun getProductsApi(token: String): List<ProductItem?>? {
        return ApiService.retrofit.getProducts("Bearer $token").body()
    }

    override suspend fun getProductApi(token: String, id: String): ProductItem? {
        return ApiService.retrofit.getProductById("Bearer $token", id).body()
    }

    override suspend fun getDailyProgressApi(
        token: String,
        getDailyProgress: GetDailyProgress
    ): DailyProgress? {
        return ApiService.retrofit.getDailyProgressByDate("Bearer $token", getDailyProgress).body()
    }

    override suspend fun createDailyProgressApi(token: String, createDailyProgress: CreateDailyProgress) {
        ApiService.retrofit.createDailyProgress("Bearer $token", createDailyProgress)
    }

    override fun getToken(): String? {
        return preferenceStorage.accessToken
    }

    override fun setToken(token: String) {
        preferenceStorage.accessToken = token
    }

    override fun getUserId(): String? {
        return preferenceStorage.userId
    }

    override fun setUserId(userId: String) {
        preferenceStorage.userId = userId
    }

    override fun getEmail(): String {
        return preferenceStorage.email
    }

    override fun setEmail(email: String) {
        preferenceStorage.email = email
    }

    override fun getName(): String {
        return preferenceStorage.name
    }

    override fun setName(name: String) {
        preferenceStorage.name = name
    }

    override fun getGender(): Boolean {
        return preferenceStorage.gender
    }

    override fun setGender(gender: Boolean) {
        preferenceStorage.gender = gender
    }

    override fun getBirthday(): Long {
        return preferenceStorage.birth
    }

    override fun setBirthday(birthday: Long) {
        preferenceStorage.birth = birthday
    }

    override fun getHeight(): Int {
        return preferenceStorage.height
    }

    override fun setHeight(height: Int) {
        preferenceStorage.height = height
    }

    override fun getActive(): Int {
        return preferenceStorage.active
    }

    override fun setActive(active: Int) {
        preferenceStorage.active = active
    }

    override fun getCurrentWeight(): Float {
        return preferenceStorage.currentWeight
    }

    override fun setCurrentWeight(currentWeight: Float) {
        preferenceStorage.currentWeight = currentWeight
    }

    override fun getGoalWeight(): Float {
        return preferenceStorage.goalWeight
    }

    override fun setGoalWeight(goalWeight: Float) {
        preferenceStorage.goalWeight = goalWeight
    }

    override fun getGoalKcal(): Int {
        return preferenceStorage.goalKcal
    }

    override fun setGoalKcal(goalKcal: Int) {
        preferenceStorage.goalKcal = goalKcal
    }

    override fun getGoalProteins(): Float {
        return preferenceStorage.goalProteins
    }

    override fun setGoalProteins(goalProteins: Float) {
        preferenceStorage.goalProteins = goalProteins
    }

    override fun getGoalCarbs(): Float {
        return preferenceStorage.goalCarbs
    }

    override fun setGoalCarbs(goalCarbs: Float) {
        preferenceStorage.goalCarbs = goalCarbs
    }

    override fun getGoalFats(): Float {
        return preferenceStorage.goalFats
    }

    override fun setGoalFats(goalFats: Float) {
        preferenceStorage.goalFats = goalFats
    }

    override fun clearPreference(): Boolean {
        preferenceStorage.clearPreference()
        return true
    }

}