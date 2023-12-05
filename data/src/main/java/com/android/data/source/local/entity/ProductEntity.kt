package com.android.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class ProductEntity(
    @PrimaryKey var id:Int,
    var title:String,
    var price:Double,
    var description:String,
    var category:String,
    var image:String,
    var rating: Rating
)


