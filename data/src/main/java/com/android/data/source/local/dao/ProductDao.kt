package com.android.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.android.data.source.local.entity.ProductEntity
import io.reactivex.Single

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(productEntity: ProductEntity): Int

    @Query("SELECT * FROM Product")
    fun getAll():MutableList<ProductEntity>


    @Delete
    fun remove(productEntity: ProductEntity)

    @Query("DELETE FROM Product")
    fun removeAll()

    @Query("SELECT * FROM Product WHERE id= :id")
    fun getProductById(id:Int) : ProductEntity?

    @Update
    fun updateProduct(productEntity: ProductEntity)


}