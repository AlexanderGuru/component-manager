package com.alexguru.component_manager.injector.lifecycle.fragment

import androidx.fragment.app.Fragment
import com.alexguru.component_manager.injector.lifecycle.ObjectLifecycleInjector
import kotlin.reflect.KClass

/**
 * Injector учитывает ЖЦ фрагмента, удаляет компонет после уничтожения корневого фрагмента
 */
abstract class FragmentInjector<Value : Any>(
    type: KClass<Value>
) : ObjectLifecycleInjector<Fragment, Value>(type) {

    override fun createLifecycleObserver(obj: Fragment, removeCallback: () -> Unit) =
        FragmentLifecycleObserver(obj, removeCallback)
}