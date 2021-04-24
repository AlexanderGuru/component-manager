package com.alexguru.feature_map

import androidx.lifecycle.ViewModel
import com.alexguru.core_db.CoordinatesDao
import javax.inject.Inject

class MapViewModel @Inject constructor(
    private val coordinatesDao: CoordinatesDao
) : ViewModel() {

}