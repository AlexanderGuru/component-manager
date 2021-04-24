package com.alexguru.component_manager.injector.lifecycle.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.alexguru.component_manager.injector.lifecycle.ObjectLifecycleObserver

/**
 * Слушатель ЖЦ fragment, в момент уничтожения fragment вызывает removeCallback()
 */
class FragmentLifecycleObserver(
    fragment: Fragment,
    removeCallback: () -> Unit
) : ObjectLifecycleObserver<Fragment>(fragment, removeCallback), LifecycleObserver {

    init {
        fragment.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {

        val fragment = objReference.get() ?: return
        val fragmentManager = fragment.requireFragmentManager()

        val isFinishingActivity = fragment.requireActivity().isFinishing
        val isRemovingFragment = fragment.isRemoving

        var isExitsNextFragment = false
        val tag = fragment.tag
        for (i in 0 until fragmentManager.backStackEntryCount) {
            val entryTag = fragmentManager.getBackStackEntryAt(i).name
            if (tag != null && entryTag != null && tag in entryTag) {
                isExitsNextFragment = true
                break
            }
        }

        if ((isFinishingActivity || isRemovingFragment) && !isExitsNextFragment) {
            removeCallback()
        }

        destroy()
    }

    override fun destroy() {
        objReference.get()?.lifecycle?.removeObserver(this)
        super.destroy()
    }
}