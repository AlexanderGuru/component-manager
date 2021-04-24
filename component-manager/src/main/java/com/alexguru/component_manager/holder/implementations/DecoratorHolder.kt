package com.alexguru.component_manager.holder.implementations

import com.alexguru.component_manager.holder.Holder

class DecoratorHolder(
    private val mainHolder: Holder
) : Holder {

    private val decorateHolder = DefaultHolder()

    override fun isExist(key: String): Boolean =
        decorateHolder.isExist(key) || mainHolder.isExist(key)

    override fun get(key: String): Any? =
        decorateHolder.get(key) ?: mainHolder.get(key)

    override fun findComponent(predicate: (Any) -> Boolean): Any? =
        decorateHolder.findComponent(predicate) ?: mainHolder.findComponent(predicate)

    override fun add(key: String, component: Any) {
        decorateHolder.add(key, component)
    }

    override fun remove(key: String) {
        decorateHolder.remove(key)
    }

    override fun clear() {
        decorateHolder.clear()
    }
}