package com.foodtracker.app.presentation.settings

import androidx.lifecycle.ViewModel
import com.foodtracker.app.domain.usecase.ClearPreferenceUseCase

class SettingsViewModel(private val clearPreferenceUseCase: ClearPreferenceUseCase) : ViewModel() {
    fun clearPreferences() = clearPreferenceUseCase.execute()
}