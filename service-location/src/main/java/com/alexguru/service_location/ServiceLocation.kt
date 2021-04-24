package com.alexguru.service_location

import androidx.lifecycle.LifecycleService
import com.alexguru.core_db.CoordinatesDao
import com.alexguru.service_location.di.ServiceLocationComponent
import javax.inject.Inject

class ServiceLocation : LifecycleService() {

    @Inject
    lateinit var coordinatesDao: CoordinatesDao

    override fun onCreate() {
        super.onCreate()
        ServiceLocationComponent.getOrCreate(this).inject(this)
    }
}