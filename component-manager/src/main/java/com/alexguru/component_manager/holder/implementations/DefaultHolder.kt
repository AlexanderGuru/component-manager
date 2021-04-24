package com.alexguru.component_manager.holder.implementations

import com.alexguru.component_manager.holder.Holder

class DefaultHolder : Holder {

    private val components = mutableMapOf<String, Any>()

    override fun isExist(key: String): Boolean = components.containsKey(key)

    override fun get(key: String): Any? = components[key]

    override fun findComponent(predicate: (Any) -> Boolean): Any? {
        for ((_, component) in components) {
            if (predicate(component)) return component
        }
        return null
    }

    override fun add(key: String, component: Any) {
        components[key] = component
    }

    override fun remove(key: String) {
        components.remove(key)
    }

    override fun clear() {
        components.clear()
    }
}