package com.android.domain.usecase

import com.android.domain.model.Category
import com.android.domain.repository.CategoryRepository
import com.android.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(private val repository: CategoryRepository):SingleUseCase<List<Category>>() {
    override fun buildUseCaseSingle(): Single<List<Category>> {
        return  repository.getCategories()
    }


}