package com.android.data.repository

import com.android.data.source.remote.ProductService
import com.android.domain.model.Category
import com.android.domain.repository.CategoryRepository
import io.reactivex.Single

class CategoryRepositoryImpl(private val productService: ProductService):CategoryRepository {
    override fun getCategories(): Single<Category> {
        return productService.getCategories()
    }
}