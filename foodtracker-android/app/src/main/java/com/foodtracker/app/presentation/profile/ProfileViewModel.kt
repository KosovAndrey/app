package com.foodtracker.app.presentation.profile

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.foodtracker.app.domain.model.User
import com.foodtracker.app.domain.usecase.*
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getNameUseCase: GetNameUseCase,
    private val getGenderUseCase: GetGenderUseCase,
    private val getBirthdayUseCase: GetBirthdayUseCase,
    private val getHeightUseCase: GetHeightUseCase,
    private val getCurrentWeightUseCase: GetCurrentWeightUseCase,
    private val getGoalWeightUseCase: GetGoalWeightUseCase,
    private val getActiveUseCase: GetActiveUseCase,
    private val getEmailUseCase: GetEmailUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val getTokenUseCase: GetTokenUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val updatePasswordUseCase: UpdatePasswordUseCase,
) : ViewModel() {
    fun getName() = getNameUseCase.execute()
    fun getGender() = getGenderUseCase.execute()
    fun getBirthday() = getBirthdayUseCase.execute()
    fun getHeight() = getHeightUseCase.execute()
    fun getCurrentWeight() = getCurrentWeightUseCase.execute()
    fun getGoalWeight() = getGoalWeightUseCase.execute()
    fun getActive() = getActiveUseCase.execute()
    fun getEmail() = getEmailUseCase.execute()

    private var _responseUser: MutableLiveData<User?> =
        MutableLiveData<User?>()
    val responseUser: LiveData<User?> = _responseUser

    val token = getTokenUseCase.execute()

    fun getUser() {
        viewModelScope.launch {
            _responseUser.value = getUserUseCase.execute(
                token = token!!,
                userId = getUserId()
            )
        }
    }

    fun getUserId() = extractUserIdFromToken(token = token!!)!!


    fun setName(username: String) {
        val user = responseUser.value
        if (user != null) {
            user.username = username
            viewModelScope.launch {
                updateUserUseCase.execute(token = token!!, user = user)
            }
        }
    }

    fun setGender(gender: Boolean) {
        val user = responseUser.value
        if (user != null) {
            user.gender = gender
            viewModelScope.launch {
                updateUserUseCase.execute(token = token!!, user = user)
            }
        }

    }

    fun setBirthdate(birthdate: Long) {
        val user = responseUser.value
        if (user != null) {
            user.birthdate = birthdate
            viewModelScope.launch {
                updateUserUseCase.execute(token = token!!, user = user)
            }
        }
    }

    fun setHeight(height: Int) {
        val user = responseUser.value
        if (user != null) {
            user.height = height
            viewModelScope.launch {
                updateUserUseCase.execute(token = token!!, user = user)
            }
        }
    }

    fun setCurrentWeight(currentWeight: Double) {
        val user = responseUser.value
        if (user != null) {
            user.currentWeight = currentWeight
            viewModelScope.launch {
                updateUserUseCase.execute(token = token!!, user = user)
            }
        }
    }

    fun setGoalWeight(goalWeight: Double) {
        val user = responseUser.value
        if (user != null) {
            user.goalWeight = goalWeight
            viewModelScope.launch {
                updateUserUseCase.execute(token = token!!, user = user)
            }
        }
    }

    fun setActive(active: Int) { // переделать под enum скорее всего или еще что
        val user = responseUser.value
        if (user != null) {
            user.active = active
            viewModelScope.launch {
                updateUserUseCase.execute(token = token!!, user = user)
            }
        }
    }

    fun setEmail(email: String) {
        val user = responseUser.value
        if (user != null) {
            user.email = email
            viewModelScope.launch {
                updateUserUseCase.execute(token = token!!, user = user)
            }
        }
    }

    fun setPassword(password: String) {
        val user = responseUser.value
        if (user != null) {
            viewModelScope.launch {
                updatePasswordUseCase.execute(token = token!!, user = user)
            }
        }
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