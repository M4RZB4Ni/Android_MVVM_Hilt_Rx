package com.android.domain.usecase

import com.android.domain.model.Product
import com.android.domain.repository.ProductRepository
import com.android.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val repository: ProductRepository):SingleUseCase<List<Product>>() {

    private var category:String?=null

    fun saveCategory(category: String){
        this.category=category
    }
    override fun buildUseCaseSingle(): Single<List<Product>> {
        return repository.getProducts(category!!)
    }
}