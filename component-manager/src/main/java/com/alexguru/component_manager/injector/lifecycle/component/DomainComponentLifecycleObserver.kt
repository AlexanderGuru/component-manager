package com.alexguru.component_manager.injector.lifecycle.component

import com.alexguru.component_manager.injector.Injector
import com.alexguru.component_manager.injector.lifecycle.ObjectLifecycleObserver
import com.alexguru.component_manager.injector.listeners.ComponentRemoveListener

/**
 * Слушатель ЖЦ component, в момент уничтожения component вызывает removeCallback()
 */
class DomainComponentLifecycleObserver(
    injector: Injector<*, *>,
    removeCallback: () -> Unit
) : ObjectLifecycleObserver<Injector<*, *>>(injector, removeCallback), ComponentRemoveListener {

    init {
        injector.addListener(this)
    }

    override fun onRemove(key: String) {
        removeCallback()
        destroy()
    }

    override fun destroy() {
        objReference.get()?.removeListener(this)
        super.destroy()
    }
}