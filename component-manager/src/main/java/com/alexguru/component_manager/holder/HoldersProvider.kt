package com.alexguru.component_manager.holder

import com.alexguru.component_manager.holder.implementations.DefaultHolder
import com.alexguru.component_manager.holder.implementations.DecoratorHolder

object HoldersProvider {

    val applicationHolder by lazy { DefaultHolder() }

    val urlSessionHolder by lazy { DecoratorHolder(applicationHolder) }
}