package com.alexguru.component_manager.injector.lifecycle

import java.lang.ref.WeakReference

open class ObjectLifecycleObserver<T>(
    obj: T,
    protected val removeCallback: () -> Unit
) {

    protected val objReference = WeakReference(obj)

    fun isCleared(): Boolean = objReference.get() == null

    open fun destroy() {
        objReference.clear()
    }
}