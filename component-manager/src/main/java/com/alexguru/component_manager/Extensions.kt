package com.alexguru.component_manager

import com.alexguru.component_manager.holder.Holder
import com.alexguru.component_manager.injector.Injector

/**
 * Поиск компонента в указанном holder для этого Injector
 */
inline fun <reified T> Injector<*, *>.findComponent(): T {
    return holder.findComponent()
}

/**
 * Поиск компонента в указанном holder
 */
inline fun <reified T> Holder.findComponent(): T {
    val predicate = object : (Any) -> Boolean {
        override fun invoke(component: Any): Boolean = component is T

        override fun toString(): String = T::class.java.simpleName
    }
    return findComponent(predicate) as T
}