package com.alexguru.core_db.di.modules

import android.content.Context
import androidx.room.Room
import com.alexguru.core_common.di.FeatureScope
import com.alexguru.core_db.AppDatabase
import com.alexguru.core_db.CoordinatesDao
import dagger.Module
import dagger.Provides

@Module
object DataModule {

    private const val DATABASE_NAME = "AppDatabase"

    @Provides
    @JvmStatic
    @FeatureScope
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @JvmStatic
    @FeatureScope
    fun provideCoordinatesDao(appDatabase: AppDatabase): CoordinatesDao = appDatabase.getCoordinatesDao()
}