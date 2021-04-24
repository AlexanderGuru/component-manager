package com.alexguru.feature_map.di

import androidx.fragment.app.Fragment
import com.alexguru.component_manager.findComponent
import com.alexguru.component_manager.holder.Holder
import com.alexguru.component_manager.injector.lifecycle.fragment.FragmentInjector
import com.alexguru.core_common.di.AppDependencies
import com.alexguru.core_common.di.FeatureScope
import com.alexguru.core_common.di.HoldersProvider
import com.alexguru.core_db.di.CoreDbDependencies
import com.alexguru.core_db.di.CoreDbDependenciesProvider
import com.alexguru.feature_map.MapFragment
import com.alexguru.feature_map.di.modules.PresentationModule
import dagger.Component

@FeatureScope
@Component(
    modules = [
        PresentationModule::class
    ],
    dependencies = [
        AppDependencies::class,
        CoreDbDependencies::class
    ]
)
interface MapComponent {

    fun inject(fragment: MapFragment)

    companion object : FragmentInjector<MapComponent>(MapComponent::class) {

        override val holder: Holder = HoldersProvider.applicationHolder

        override fun create(params: Fragment): MapComponent =
            DaggerMapComponent.builder()
                .appDependencies(findComponent())
                .dbDependencies(CoreDbDependenciesProvider.getOrCreate(this))
                .build()
    }

    @Component.Builder
    interface Builder {
        fun appDependencies(dependencies: AppDependencies): Builder
        fun dbDependencies(dependencies: CoreDbDependencies): Builder
        fun build(): MapComponent
    }
}