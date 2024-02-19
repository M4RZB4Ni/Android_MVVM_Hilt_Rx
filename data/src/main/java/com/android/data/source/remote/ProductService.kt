package com.android.data.source.remote

import com.android.domain.model.Product
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("/products/{id}")
    fun getProductDetail(@Path("id") id:Int):Single<Product>

    @GET("products/")
    fun getProducts():Single<List<Product>>
}