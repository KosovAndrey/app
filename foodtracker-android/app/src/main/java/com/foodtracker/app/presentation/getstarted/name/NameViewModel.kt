package com.foodtracker.app.presentation.getstarted.name

import androidx.lifecycle.ViewModel
import com.foodtracker.app.domain.usecase.SetNameUseCase

class NameViewModel(val setNameUseCase: SetNameUseCase) : ViewModel() {
    fun setName(name: String) = setNameUseCase.execute(name)
}