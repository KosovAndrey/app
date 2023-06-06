package com.foodtracker.app.presentation.getstarted.active

import androidx.lifecycle.ViewModel
import com.foodtracker.app.domain.usecase.SetActiveUseCase

class ActiveViewModel(private val setActiveUseCase: SetActiveUseCase) : ViewModel() {
    fun setLightlyActive() = setActiveUseCase.execute(active = "Lightly Active")
    fun setModeratelyActive() = setActiveUseCase.execute(active = "Moderately Active")
    fun setActiveActive() = setActiveUseCase.execute(active = "Active")
    fun setVeryActive() = setActiveUseCase.execute(active = "Very Active")
}