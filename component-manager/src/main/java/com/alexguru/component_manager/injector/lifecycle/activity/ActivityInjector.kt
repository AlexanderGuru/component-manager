package com.alexguru.component_manager.injector.lifecycle.activity

import android.app.Activity
import com.alexguru.component_manager.injector.lifecycle.ObjectLifecycleInjector
import kotlin.reflect.KClass

/**
 * Injector учитывает ЖЦ activity, удаляет компонет после уничтожения activity
 */
abstract class ActivityInjector<Value : Any>(
    type: KClass<Value>
) : ObjectLifecycleInjector<Activity, Value>(type) {

    override fun createLifecycleObserver(obj: Activity, removeCallback: () -> Unit) =
        ActivityLifecycleObserver(obj, removeCallback)
}