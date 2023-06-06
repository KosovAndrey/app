package com.foodtracker.app.presentation.getstarted.height

import androidx.lifecycle.ViewModel
import com.foodtracker.app.domain.usecase.SetHeightUseCase

class HeightViewModel(private val setHeightUseCase: SetHeightUseCase) : ViewModel(){
    fun setHeight(height: String) = setHeightUseCase.execute(height = height)
}