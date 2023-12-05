package com.android.data.mapper

import com.android.data.source.local.entity.ProductEntity
import com.android.domain.model.Product

fun Product.toEntity() = ProductEntity(
    id = id,
    title = title,
    price = price,
    category= category,
    image = image,
    rating = rating,
    description = description
)
