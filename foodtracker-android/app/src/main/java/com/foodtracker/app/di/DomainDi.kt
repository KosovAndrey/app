package com.foodtracker.app.di

import com.foodtracker.app.domain.usecase.*
import org.koin.dsl.module

val domainDi = module {

    factory {
        GetProductsUseCase(get())
    }
    factory {
        ClearPreferenceUseCase(get())
    }
    factory {
        GetActiveUseCase(get())
    }
    factory {
        GetBirthdayUseCase(get())
    }
    factory {
        GetCurrentWeightUseCase(get())
    }
    factory {
        GetEmailUseCase(get())
    }
    factory {
        GetGenderUseCase(get())
    }
    factory {
        GetGoalWeightUseCase(get())
    }
    factory {
        GetHeightUseCase(get())
    }
    factory {
        GetNameUseCase(get())
    }
    factory {
        GetTokenUseCase(get())
    }
    factory {
        GetUserIdUseCase(get())
    }
    factory {
        LoginUserUseCase(get())
    }
    factory {
        RegistrationUserUseCase(get())
    }
    factory {
        SetActiveUseCase(get())
    }
    factory {
        SetBirthdayUseCase(get())
    }
    factory {
        SetCurrentWeightUseCase(get())
    }
    factory {
        SetEmailUseCase(get())
    }
    factory {
        SetGenderUseCase(get())
    }
    factory {
        SetGoalWeightUseCase(get())
    }
    factory {
        SetHeightUseCase(get())
    }
    factory {
        SetNameUseCase(get())
    }
    factory {
        SetTokenUseCase(get())
    }
    factory {
        SetUserIdUseCase(get())
    }
    factory {
        GetDailyProgressUseCase(get())
    }
    factory {
        CreateDailyProgressUseCase(get())
    }
    factory {
        GetUserUseCase(get())
    }
    factory {
        UpdateUserUseCase(get())
    }
    factory {
        UpdatePasswordUseCase(get())
    }
    factory {
        GetGoalKcalUseCase(get())
    }
    factory {
        GetGoalProteinsUseCase(get())
    }
    factory {
        GetGoalCarbsUseCase(get())
    }
    factory {
        GetGoalFatsUseCase(get())
    }
    factory {
        SetGoalKcalUseCase(get())
    }
    factory {
        SetGoalProteinsUseCase(get())
    }
    factory {
        SetGoalCarbsUseCase(get())
    }
    factory {
        SetGoalFatsUseCase(get())
    }
}