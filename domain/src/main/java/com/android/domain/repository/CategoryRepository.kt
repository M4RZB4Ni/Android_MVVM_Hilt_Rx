package com.android.domain.repository

import com.android.domain.model.Category
import io.reactivex.Single

interface CategoryRepository {
    fun getCategories():Single<Category>
}