package com.alexguru.core_common.di

import com.alexguru.component_manager.holder.implementations.DefaultHolder

object HoldersProvider {

    val applicationHolder by lazy { DefaultHolder() }
}