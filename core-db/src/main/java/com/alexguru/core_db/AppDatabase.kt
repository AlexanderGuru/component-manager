package com.alexguru.core_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexguru.core_db.entities.CoordinatesEntity

@Database(
    entities = [
        CoordinatesEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getCoordinatesDao(): CoordinatesDao
}