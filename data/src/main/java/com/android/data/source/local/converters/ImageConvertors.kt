package com.android.data.source.local.converters

import androidx.room.TypeConverter

class ImageConvertors {

    @TypeConverter
    fun fromImages(images: ArrayList<String>): String{
        return  images.toString()
    }

    @TypeConverter
    fun toImages(imagesString:String):ArrayList<String>
    {
        return ArrayList(imagesString.split(" "))
    }
}