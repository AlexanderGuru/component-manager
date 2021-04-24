package com.alexguru.component_manager.injector.lifecycle.service

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.OnLifecycleEvent
import com.alexguru.component_manager.injector.lifecycle.ObjectLifecycleObserver

/**
 * Слушатель ЖЦ fragment, в момент уничтожения fragment вызывает removeCallback()
 */
class ServiceLifecycleObserver(
    service: LifecycleService,
    removeCallback: () -> Unit
) : ObjectLifecycleObserver<LifecycleService>(service, removeCallback), LifecycleObserver {

    init {
        service.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        destroy()
    }

    override fun destroy() {
        objReference.get()?.lifecycle?.removeObserver(this)
        super.destroy()
    }
}