package com.alexguru.app

import android.app.Application
import com.alexguru.app.di.AppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AppComponent.getOrCreate(this)
    }
}