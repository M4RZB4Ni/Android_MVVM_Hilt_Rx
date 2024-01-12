package com.android.data.repository

import com.android.data.mapper.toEntity
import com.android.data.source.local.AppDatabase
import com.android.data.source.remote.CategoryService
import com.android.domain.model.Category
import com.android.domain.repository.CategoryRepository
import io.reactivex.Single

class CategoryRepositoryImpl(private val service: CategoryService,private val appDatabase: AppDatabase):CategoryRepository {
    override fun getCategories(): Single<List<Category>> {
        return  service.getCategories()
    }

    override fun getCategoryDetails(id: Int?): Single<Category> {
        return service.getCategory(id)
    }

    override fun deleteCategory(category: Category) {
        return appDatabase.categoryDao.remove(category.toEntity())
    }

    override fun addCategory(category: Category) {
         appDatabase.categoryDao.insertCategory(category.toEntity())
    }

}