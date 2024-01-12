package com.android.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Category")
data class CategoryEntity(
    @PrimaryKey var id:Int,
    val name:String,
    val image:String
)




