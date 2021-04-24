package com.alexguru.core_db.di

import com.alexguru.component_manager.findComponent
import com.alexguru.component_manager.holder.Holder
import com.alexguru.component_manager.injector.Injector
import com.alexguru.component_manager.injector.lifecycle.component.ComponentInjector
import com.alexguru.core_common.di.AppDependencies
import com.alexguru.core_common.di.FeatureScope
import com.alexguru.core_common.di.HoldersProvider
import com.alexguru.core_db.CoordinatesDao
import com.alexguru.core_db.di.modules.DataModule
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        AppDependencies::class
    ],
    modules = [
        DataModule::class
    ]
)
internal interface CoreDbComponent : CoreDbDependencies

interface CoreDbDependencies {
    fun provideCoordinatesDao(): CoordinatesDao
}

object CoreDbDependenciesProvider :
    ComponentInjector<CoreDbDependencies>(CoreDbDependencies::class) {

    override val holder: Holder = HoldersProvider.applicationHolder

    override fun create(params: Injector<*, *>): CoreDbDependencies =
        DaggerCoreDbComponent.builder()
            .appDependencies(findComponent())
            .build()
}