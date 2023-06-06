package com.foodtracker.app.presentation.getstarted.goalWeight

import androidx.lifecycle.ViewModel
import com.foodtracker.app.domain.usecase.GetCurrentWeightUseCase
import com.foodtracker.app.domain.usecase.SetGoalWeightUseCase

class GoalWeightViewModel(
    private val setGoalWeightUseCase: SetGoalWeightUseCase,
    private val getCurrentWeightUseCase: GetCurrentWeightUseCase
) : ViewModel() {
    fun setGoalWeight(goalWeight: String) = setGoalWeightUseCase.execute(goalWeight = goalWeight)
    fun getCurrentWeight() = getCurrentWeightUseCase.execute()
}