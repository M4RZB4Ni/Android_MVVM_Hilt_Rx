package com.android.data.source.local.converters

import androidx.room.TypeConverter
import com.android.domain.model.Category
import org.json.JSONObject

class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String{
        return JSONObject().apply {
            put("id",category.id)
            put("name",category.name)
            put("image",category.image)
        }.toString()
    }

    @TypeConverter
    fun toCategory(categoryRaw:String): Category {
        val json = JSONObject(categoryRaw)
        return Category(json.getInt("id"),json.getString("name"),json.getString("image"))
    }






}