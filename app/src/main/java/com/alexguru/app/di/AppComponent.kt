package com.alexguru.app.di

import android.content.Context
import com.alexguru.app.App
import com.alexguru.component_manager.holder.Holder
import com.alexguru.component_manager.injector.Injector
import com.alexguru.core_common.di.AppDependencies
import com.alexguru.core_common.di.HoldersProvider
import dagger.BindsInstance
import dagger.Component

@Component
interface AppComponent : AppDependencies {

    companion object : Injector<App, AppDependencies>(AppDependencies::class) {

        override val holder: Holder = HoldersProvider.applicationHolder

        override fun create(params: App): AppDependencies =
            DaggerAppComponent.builder()
                .context(params)
                .build()
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }
}