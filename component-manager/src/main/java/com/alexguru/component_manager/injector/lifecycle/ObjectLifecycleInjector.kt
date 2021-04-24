package com.alexguru.component_manager.injector.lifecycle

import com.alexguru.component_manager.injector.Injector
import kotlin.reflect.KClass

abstract class ObjectLifecycleInjector<Obj : Any, Value : Any>(
    type: KClass<Value>
) : Injector<Obj, Value>(type) {

    private val elements = mutableMapOf<KClass<out Obj>, ObjectLifecycleObserver<Obj>>()

    override fun getOrCreate(params: Obj): Value {

        val lifecycleKey = params::class

        val lifecycle = createLifecycleObserver(params) {
            elements.remove(lifecycleKey)?.destroy()
            if (elements.isEmpty()) {
                destroy()
            }
        }

        elements[lifecycleKey] = lifecycle

        return super.getOrCreate(params)
    }

    protected abstract fun createLifecycleObserver(
        obj: Obj,
        removeCallback: () -> Unit
    ): ObjectLifecycleObserver<Obj>

    override fun destroy() {
        elements.values.forEach { lifecycle ->
            lifecycle.destroy()
        }
        super.destroy()
    }
}