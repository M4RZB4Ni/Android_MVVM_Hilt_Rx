package com.android.domain.usecase

import com.android.domain.model.Product
import com.android.domain.repository.ProductRepository
import com.android.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetProductDetailUseCase @Inject constructor(
    private val repository: ProductRepository
):SingleUseCase<Product>() {

    private var productId:Int? = null

    fun saveProductId(id:Int){
        productId=id
    }
    override fun buildUseCaseSingle(): Single<Product> {
        return repository.getProductDetail(productId)
    }

    fun addToBasket(product: Product){
        repository.addProduct(product)
    }
    fun removeFromBasket(product: Product)
    {
        repository.removeProduct(product)
    }
    fun isInBasket(id:Int):Boolean
    {
        return repository.isInBasket(id)
    }
}