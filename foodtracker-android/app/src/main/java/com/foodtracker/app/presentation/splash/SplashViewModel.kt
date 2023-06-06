package com.foodtracker.app.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.foodtracker.app.domain.usecase.GetTokenUseCase

class SplashViewModel(
    private val getTokenUseCase: GetTokenUseCase
) : ViewModel() {

    fun getToken() = getTokenUseCase.execute()
//    private val _token: MutableLiveData<String?> = MutableLiveData<String?>()
//    val token: LiveData<String?> = _token

}
