package com.alexguru.component_manager.injector

import com.alexguru.component_manager.holder.Holder
import com.alexguru.component_manager.injector.exceptions.InstanceNotFoundException
import com.alexguru.component_manager.injector.listeners.ComponentRemovePublisher
import kotlin.reflect.KClass

abstract class Injector<Params, Value : Any>(
    private val type: KClass<Value>
) : ComponentRemovePublisher() {

    abstract val holder: Holder

    protected val key = type.simpleName!!

    open fun getOrCreate(params: Params): Value {
        return if (holder.isExist(key)) {
            getHolderValue()!!
        } else {
            create(params).also { component ->
                holder.add(key, component)
            }
        }
    }

    protected abstract fun create(params: Params): Value

    fun get(): Value = getHolderValue() ?: throw InstanceNotFoundException(type)

    open fun destroy() {
        holder.remove(key)
        notify(key)
    }

    @Suppress("UNCHECKED_CAST")
    private fun getHolderValue(): Value? = holder.get(key) as Value?
}