package com.alexguru.component_manager.injector.listeners

open class ComponentRemovePublisher {

    private val removeListeners = mutableListOf<ComponentRemoveListener>()

    fun addListener(listener: ComponentRemoveListener) {
        removeListeners += listener
    }

    fun removeListener(listener: ComponentRemoveListener) {
        removeListeners -= listener
    }

    protected fun notify(key: String) {
        removeListeners.toList().forEach {
            it.onRemove(key)
        }
    }
}