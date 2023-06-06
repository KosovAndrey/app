package com.foodtracker.app.presentation.diary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.foodtracker.app.domain.model.CreateDailyProgress
import com.foodtracker.app.domain.model.DailyProgress
import com.foodtracker.app.domain.model.ProductItem
import com.foodtracker.app.domain.usecase.*
import kotlinx.coroutines.launch
import java.util.*

class DiaryViewModel(
    private val getUserIdUseCase: GetUserIdUseCase,
    private val getTokenUseCase: GetTokenUseCase,
    private val getDailyProgressUseCase: GetDailyProgressUseCase,
    private val createDailyProgressUseCase: CreateDailyProgressUseCase,
    private val getGoalKcalUseCase: GetGoalKcalUseCase,
    private val getGoalProteinsUseCase: GetGoalProteinsUseCase,
    private val getGoalCarbsUseCase: GetGoalCarbsUseCase,
    private val getGoalFatsUseCase: GetGoalFatsUseCase
) : ViewModel() {

    private var _responseDailyProgress: MutableLiveData<DailyProgress?> =
        MutableLiveData<DailyProgress?>()
    val responseDailyProgress: LiveData<DailyProgress?> = _responseDailyProgress

    val token = getTokenUseCase.execute()
//        ?: "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJ1c2VycyIsImlzcyI6Imh0dHBzOi8vMC4wLjAuMDo4MDgwIiwiZXhwIjoxNzE2Mzk5ODg5LCJ1c2VySWQiOiI2NDVhYTBhYWM3ZjkyZTI4OTA3NjRlNDQifQ.8Fnhzi5JpEh8gqvSmyqycbX4UJWgM7dl_ay9Kuq_AdY"

    //val userId1 = getUserId() ?: ""
    fun getUserIdd() = getUserIdUseCase.execute()
    fun getUserId() = extractUserIdFromToken(token = token!!) ?: ""

    fun getDailyProgress() {
        viewModelScope.launch {
            _responseDailyProgress.value = getDailyProgressUseCase.execute(
                token = token!!,
                userId = getUserId(),
                date = getCurrentUnixDay())
        }
    }

    fun createDailyProgress() {
        viewModelScope.launch {
            createDailyProgressUseCase.execute(
                token = token!!,
                CreateDailyProgress(
                    userId = getUserId(),
                    date = getCurrentUnixDay(),
                    currentKcal = 0,
                    goalKcal = getGoalKcalUseCase.execute()!!,
                    currentProteins = 0.0,
                    goalProteins = getGoalProteinsUseCase.execute()!!.toDouble(),
                    currentCarbs = 0.0,
                    goalCarbs = getGoalCarbsUseCase.execute()!!.toDouble(),
                    currentFats = 0.0,
                    goalFats = getGoalFatsUseCase.execute()!!.toDouble(),
                    currentWater = 0.0,
                    goalWater = 3000.0//getGoalWater()
                )
            )

        }
        getDailyProgress()
    }

    private fun extractUserIdFromToken(token: String): String? {
        try {
            val algorithm = Algorithm.HMAC256("Po10li20tikA")
            val verifier = JWT.require(algorithm).build()
            val jwt = verifier.verify(token)
            val userId = jwt.getClaim("userId").asString()
            return userId
        } catch (exception: Exception) {
            // Обработка ошибок при расшифровке токена
            return null
        }
    }

    private fun getCurrentUnixDay(): Long {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.timeInMillis / 1000
    }

//    fun syncNotes(
//        onDone: (()->Unit)? = null
//    ) = viewModelScope.launch{
//
//        syncNotes1()
//        onDone?.invoke()
//    }
}
