package com.foodtracker.app.presentation.getstarted.currentWeight

import androidx.lifecycle.ViewModel
import com.foodtracker.app.domain.usecase.SetCurrentWeightUseCase

class CurrentWeightViewModel(private val setCurrentWeightUseCase: SetCurrentWeightUseCase) : ViewModel(){
    fun setCurrentWeight(currentWeight: String) = setCurrentWeightUseCase.execute(currentWeight = currentWeight)
}