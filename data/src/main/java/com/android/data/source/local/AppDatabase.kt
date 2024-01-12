package com.android.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.data.source.local.dao.ProductDao
import com.android.data.source.local.entity.ProductEntity
import com.android.data.source.local.converters.CategoryConverter
import com.android.data.source.local.converters.ImageConvertors
import com.android.data.source.local.dao.CategoryDao
import com.android.data.source.local.entity.CategoryEntity

/**
 * To manage data items that can be accessed, updated
 * & maintain relationships between them
 *
 */
@Database(entities = [ProductEntity::class,CategoryEntity::class], version = 1, exportSchema = false)
@TypeConverters(CategoryConverter::class, ImageConvertors::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val productDao:ProductDao

    abstract val categoryDao:CategoryDao

    companion object {
        const val DB_NAME = "ProductDatabase.db"
    }
}
