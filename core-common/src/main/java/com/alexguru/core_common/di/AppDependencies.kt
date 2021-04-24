package com.alexguru.core_common.di

import android.content.Context

interface AppDependencies {
    fun provideContext(): Context
}