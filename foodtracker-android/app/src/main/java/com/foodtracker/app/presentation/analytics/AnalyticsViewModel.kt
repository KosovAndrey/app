package com.foodtracker.app.presentation.analytics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.foodtracker.app.domain.model.DailyProgress
import com.foodtracker.app.domain.model.ProductItem
import com.foodtracker.app.domain.usecase.GetTokenUseCase


class AnalyticsViewModel(
    private val getTokenUseCase: GetTokenUseCase
) : ViewModel() {

//    private val token = getTokenUseCase.execute()
//
//    fun getUserId() = extractUserIdFromToken(token = token!!) ?: ""
//
//    private var _responseDailyProgresses: MutableLiveData<List<DailyProgress?>> =
//        MutableLiveData<List<DailyProgress?>>()
//    val responseDailyProgresses: LiveData<List<DailyProgress?>> = _responseDailyProgresses
//
//    fun getDailyProgresses() {
//        viewModelScope.launch {
//            _responseDailyProgresses.value = getDailyProgressesUseCase.execute(token!!, getUserId())
//        }
//    }
//
//    private fun extractUserIdFromToken(token: String): String? {
//        try {
//            val algorithm = Algorithm.HMAC256("Po10li20tikA")
//            val verifier = JWT.require(algorithm).build()
//            val jwt = verifier.verify(token)
//            val userId = jwt.getClaim("userId").asString()
//            return userId
//        } catch (exception: Exception) {
//            // Обработка ошибок при расшифровке токена
//            return null
//        }
//    }
}