package com.android.domain.repository

import com.android.domain.model.Product
import io.reactivex.Single

/**
 * make an interaction between [ProductRepositoryImp] & [GetProductUseCase]
 * */
interface ProductRepository {
    fun getProducts(category:String?):Single<List<Product>>
    fun getProductDetail(id:Int?):Single<Product>
    fun removeProduct(product: Product)
    fun addProduct(product: Product)
    fun isInBasket(id:Int):Boolean
}