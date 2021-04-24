package com.alexguru.component_manager.injector.lifecycle.activity

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.alexguru.component_manager.injector.lifecycle.ObjectLifecycleObserver

/**
 * Слушатель ЖЦ activity, в момент уничтожения activity вызывает removeCallback()
 */
class ActivityLifecycleObserver(
    obj: Activity,
    removeCallback: () -> Unit
) : ObjectLifecycleObserver<Activity>(obj, removeCallback), Application.ActivityLifecycleCallbacks {

    init {
        obj.application.registerActivityLifecycleCallbacks(this)
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        // not implement
    }

    override fun onActivityStarted(activity: Activity) {
        // not implement
    }

    override fun onActivityResumed(activity: Activity) {
        // not implement
    }

    override fun onActivityPaused(activity: Activity) {
        // not implement
    }

    override fun onActivityStopped(activity: Activity) {
        // not implement
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        // not implement
    }

    override fun onActivityDestroyed(activity: Activity) {
        removeCallback()
        destroy()
    }

    override fun destroy() {
        objReference.get()?.application?.unregisterActivityLifecycleCallbacks(this)
        super.destroy()
    }
}