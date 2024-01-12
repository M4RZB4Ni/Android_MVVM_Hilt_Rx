package com.android.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.domain.model.Category

@Entity(tableName = "Product")
data class ProductEntity(
    @PrimaryKey var id:Int,
    val title:String,
    val price:Double,
    val description:String,
    val category: Category,
    val images:ArrayList<String>,
    val rating: Double
)


