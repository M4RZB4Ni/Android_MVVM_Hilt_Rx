package com.android.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.android.data.source.local.entity.CategoryEntity


@Dao
interface CategoryDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(categoryEntity: CategoryEntity): Long


    @Query("SELECT * FROM Category")
    fun getAll():MutableList<CategoryEntity>

    @Delete
    fun remove(categoryEntity: CategoryEntity)

    @Query("DELETE FROM Category")
    fun removeAll()

    @Query("SELECT * FROM CATEGORY WHERE id=:id")
    fun getCategory(id:Int): CategoryEntity?

    @Update
    fun updateCategory(categoryEntity: CategoryEntity)
}