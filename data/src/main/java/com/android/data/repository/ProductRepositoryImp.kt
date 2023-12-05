package com.android.data.repository

import com.android.data.mapper.toEntity
import com.android.data.source.local.AppDatabase
import com.android.data.source.remote.ProductService
import com.android.domain.model.Product
import com.android.domain.repository.ProductRepository
import io.reactivex.Single

class ProductRepositoryImp(private val appDatabase: AppDatabase,private val productService: ProductService):ProductRepository {
    override fun getProducts(category: String?): Single<List<Product>> {
        return productService.getProducts()
    }

    override fun getProductDetail(id: Int?): Single<Product> {
        return productService.getProductDetail(id = id!!)
    }

    override fun removeProduct(product: Product) {
        return appDatabase.productDao.remove(product.toEntity())
    }

    override fun addProduct(product: Product) {
         appDatabase.productDao.insertProduct(product.toEntity())
    }

    override fun isInBasket(id: Int): Boolean {
        return appDatabase.productDao.getProductById(id)!= null
    }

}