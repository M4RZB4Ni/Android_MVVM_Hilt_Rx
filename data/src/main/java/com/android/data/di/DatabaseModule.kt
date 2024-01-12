package com.android.data.di

import android.app.Application
import androidx.room.Room
import com.android.data.source.local.AppDatabase
import com.android.data.source.local.dao.CategoryDao
import com.android.data.source.local.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).allowMainThreadQueries().build()
    }

    @Provides
    internal fun provideProductDao(appDatabase: AppDatabase): ProductDao {
        return appDatabase.productDao
    }

    @Provides
    internal fun provideCategoryDao(appDatabase: AppDatabase): CategoryDao{
        return appDatabase.categoryDao
    }
}
