package com.foodtracker.app.presentation.getstarted.birthday

import androidx.lifecycle.ViewModel
import com.foodtracker.app.domain.usecase.SetBirthdayUseCase

class BirthdayViewModel(private val setBirthdayUseCase: SetBirthdayUseCase) : ViewModel(){
    fun setBirthday(birthday: String) = setBirthdayUseCase.execute(birthday = birthday)
}