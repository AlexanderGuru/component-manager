package com.alexguru.component_manager.injector

import kotlin.reflect.KClass

abstract class ParameterlessInjector<Value : Any>(
    type: KClass<Value>
) : Injector<Nothing?, Value>(type) {

    fun getOrCreate(): Value = getOrCreate(null)

    final override fun create(params: Nothing?): Value = create()

    protected abstract fun create(): Value
}
