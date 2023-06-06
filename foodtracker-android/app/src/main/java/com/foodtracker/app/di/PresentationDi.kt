package com.foodtracker.app.di

import com.foodtracker.app.domain.usecase.GetDailyProgressUseCase
import com.foodtracker.app.presentation.diary.DiaryViewModel
import com.foodtracker.app.presentation.getstarted.active.ActiveViewModel
import com.foodtracker.app.presentation.getstarted.birthday.BirthdayViewModel
import com.foodtracker.app.presentation.getstarted.currentWeight.CurrentWeightViewModel
import com.foodtracker.app.presentation.getstarted.gender.GenderViewModel
import com.foodtracker.app.presentation.getstarted.goalWeight.GoalWeightViewModel
import com.foodtracker.app.presentation.getstarted.height.HeightViewModel
import com.foodtracker.app.presentation.getstarted.name.NameViewModel
import com.foodtracker.app.presentation.login.LoginViewModel
import com.foodtracker.app.presentation.products.ProductsViewModel
import com.foodtracker.app.presentation.profile.ProfileViewModel
import com.foodtracker.app.presentation.register.RegisterViewModel
import com.foodtracker.app.presentation.settings.SettingsViewModel
import com.foodtracker.app.presentation.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationDi = module {
    viewModel {
        LoginViewModel(
            loginUserUseCase = get(),
            setTokenUseCase = get(),
            setEmailUseCase = get(),
            setUserIdUseCase = get()
        )
    }
    viewModel {
        SplashViewModel(
            getTokenUseCase = get()
        )
    }
    viewModel {
        ProductsViewModel(
            getProductsUseCase = get(),
            getTokenUseCase = get()
        )
    }
    viewModel {
        NameViewModel(
            setNameUseCase = get()
        )
    }
    viewModel {
        ActiveViewModel(
            setActiveUseCase = get()
        )
    }
    viewModel {
        GenderViewModel(
            setGenderUseCase = get()
        )
    }
    viewModel {
        CurrentWeightViewModel(
            setCurrentWeightUseCase = get()
        )
    }
    viewModel {
        GoalWeightViewModel(
            setGoalWeightUseCase = get(),
            getCurrentWeightUseCase = get()
        )
    }
    viewModel {
        HeightViewModel(
            setHeightUseCase = get()
        )
    }
    viewModel {
        BirthdayViewModel(
            setBirthdayUseCase = get()
        )
    }
    viewModel {
        ProfileViewModel(
            getNameUseCase = get(),
            getActiveUseCase = get(),
            getBirthdayUseCase = get(),
            getCurrentWeightUseCase = get(),
            getGenderUseCase = get(),
            getGoalWeightUseCase = get(),
            getHeightUseCase = get(),
            getEmailUseCase = get(),
            getUserUseCase = get(),
            getTokenUseCase = get(),
            updateUserUseCase = get(),
            updatePasswordUseCase = get()
        )
    }
    viewModel {
        RegisterViewModel(
            getNameUseCase = get(),
            getActiveUseCase = get(),
            getBirthdayUseCase = get(),
            getCurrentWeightUseCase = get(),
            getGenderUseCase = get(),
            getGoalWeightUseCase = get(),
            getHeightUseCase = get(),
            setEmailUseCase = get(),
            setTokenUseCase = get(),
            registrationUserUseCase = get(),
            setGoalCarbsUseCase = get(),
            setGoalFatsUseCase = get(),
            setGoalKcalUseCase = get(),
            setGoalProteinsUseCase = get()
        )
    }
    viewModel {
        DiaryViewModel(
            getUserIdUseCase = get(),
            getTokenUseCase = get(),
            getDailyProgressUseCase = get(),
            createDailyProgressUseCase = get(),
            getGoalKcalUseCase = get(),
            getGoalCarbsUseCase = get(),
            getGoalFatsUseCase = get(),
            getGoalProteinsUseCase = get()
        )
    }
    viewModel {
        SettingsViewModel(
            clearPreferenceUseCase = get()
        )
    }
}


