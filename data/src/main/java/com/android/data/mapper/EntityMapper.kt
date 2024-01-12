package com.android.data.mapper

import com.android.data.source.local.entity.CategoryEntity
import com.android.data.source.local.entity.ProductEntity
import com.android.domain.model.Category
import com.android.domain.model.Product

fun Product.toEntity() = ProductEntity(
    id = id,
    title = title,
    price = price,
    category = category,
    images = images,
    rating = rating,
    description = description
)

fun Category.toEntity() = CategoryEntity(
    id=id,
    name=name,
    image=image
)
