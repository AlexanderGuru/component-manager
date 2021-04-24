package com.alexguru.component_manager.injector.lifecycle.component

import com.alexguru.component_manager.injector.Injector
import com.alexguru.component_manager.injector.lifecycle.ObjectLifecycleInjector
import kotlin.reflect.KClass

abstract class DomainComponentInjector<Value : Any>(
    type: KClass<Value>
) : ObjectLifecycleInjector<Injector<*, *>, Value>(type) {

    override fun createLifecycleObserver(obj: Injector<*, *>, removeCallback: () -> Unit) =
        DomainComponentLifecycleObserver(obj, removeCallback)
}