package com.alexguru.component_manager.injector.lifecycle.service

import androidx.lifecycle.LifecycleService
import com.alexguru.component_manager.injector.lifecycle.ObjectLifecycleInjector
import kotlin.reflect.KClass

/**
 * Injector учитывает ЖЦ сервиса, удаляет компонет после уничтожения сервиса
 */
abstract class ServiceInjector<Value : Any>(
    type: KClass<Value>
) : ObjectLifecycleInjector<LifecycleService, Value>(type) {

    override fun createLifecycleObserver(obj: LifecycleService, removeCallback: () -> Unit) =
        ServiceLifecycleObserver(obj, removeCallback)
}