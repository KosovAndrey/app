package com.foodtracker.app

import android.app.Application
import com.foodtracker.app.di.dataDi
import com.foodtracker.app.di.domainDi
import com.foodtracker.app.di.presentationDi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(presentationDi, dataDi, domainDi))
        }
    }
}