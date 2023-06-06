package com.foodtracker.app.di

import com.foodtracker.app.data.repository.FoodRepositoryImpl
import com.foodtracker.app.domain.repository.FoodRepository
import org.koin.dsl.module

val dataDi = module {
    single<FoodRepository> {
        FoodRepositoryImpl(context = get())
    }
}