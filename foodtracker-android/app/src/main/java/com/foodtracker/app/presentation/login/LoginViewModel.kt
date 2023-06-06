package com.foodtracker.app.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.foodtracker.app.domain.model.UserLogin
import com.foodtracker.app.domain.usecase.LoginUserUseCase
import com.foodtracker.app.domain.usecase.SetEmailUseCase
import com.foodtracker.app.domain.usecase.SetTokenUseCase
import com.foodtracker.app.domain.usecase.SetUserIdUseCase
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUserUseCase: LoginUserUseCase,
    private val setTokenUseCase: SetTokenUseCase,
    private val setEmailUseCase: SetEmailUseCase,
    private val setUserIdUseCase: SetUserIdUseCase
) : ViewModel() {

    private val _token: MutableLiveData<String?> = MutableLiveData<String?>()
    val token: LiveData<String?> = _token

    fun login(userLogin: UserLogin) {
        viewModelScope.launch {
            _token.value = loginUserUseCase.execute(userLogin)
            _token.value?.let { setTokenUseCase.execute(it) }
        }
    }

    fun f(token: String) {
        setUserId(token)
        setTokenUseCase.execute(token)
    }

    fun setEmail(email: String) = setEmailUseCase.execute(email)

    private fun setUserId(token: String) {
        val userId = extractUserIdFromToken(token = token) ?: ""
        setUserIdUseCase.execute(userId)
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
}