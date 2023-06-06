package com.foodtracker.app.presentation.getstarted.gender

import androidx.lifecycle.ViewModel
import com.foodtracker.app.domain.usecase.SetGenderUseCase

class GenderViewModel(private val setGenderUseCase: SetGenderUseCase) : ViewModel(){
    fun setMaleGender() = setGenderUseCase.execute("Male")
    fun setFemaleGender() = setGenderUseCase.execute("Female")
}