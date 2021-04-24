package com.alexguru.core_db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CoordinatesTable")
data class CoordinatesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val latitude: Double,
    val longitude: Double
)
