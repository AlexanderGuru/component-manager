package com.alexguru.service_location.di

import androidx.lifecycle.LifecycleService
import com.alexguru.component_manager.findComponent
import com.alexguru.component_manager.holder.Holder
import com.alexguru.component_manager.injector.lifecycle.service.ServiceInjector
import com.alexguru.core_common.di.AppDependencies
import com.alexguru.core_common.di.HoldersProvider
import com.alexguru.core_db.di.CoreDbDependencies
import com.alexguru.core_db.di.CoreDbDependenciesProvider
import com.alexguru.service_location.ServiceLocation
import dagger.Component

@Component(
    dependencies = [
        AppDependencies::class,
        CoreDbDependencies::class
    ]
)
interface ServiceLocationComponent {

    fun inject(service: ServiceLocation)

    companion object : ServiceInjector<ServiceLocationComponent>(ServiceLocationComponent::class) {

        override val holder: Holder = HoldersProvider.applicationHolder

        override fun create(params: LifecycleService): ServiceLocationComponent =
            DaggerServiceLocationComponent.builder()
                .appDependencies(findComponent())
                .dbDependencies(CoreDbDependenciesProvider.getOrCreate(this))
                .build()
    }

    @Component.Builder
    interface Builder {
        fun appDependencies(dependencies: AppDependencies): Builder
        fun dbDependencies(dependencies: CoreDbDependencies): Builder
        fun build(): ServiceLocationComponent
    }
}