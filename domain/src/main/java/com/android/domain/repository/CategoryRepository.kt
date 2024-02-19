package com.android.domain.repository

import com.android.domain.model.Category
import io.reactivex.Single

interface CategoryRepository {

    
    fun getCategories():Single<List<Category>>
    
    fun getCategoryDetails(id:Int?):Single<Category>
    
    fun deleteCategory(category: Category)

    fun addCategory(category: Category)


}