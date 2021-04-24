package com.alexguru.component_manager.injector.exceptions

import kotlin.reflect.KClass

class InstanceNotFoundException(clazz: KClass<out Any>) :
    Throwable("Dependency instance not found: ${clazz.simpleName}")
