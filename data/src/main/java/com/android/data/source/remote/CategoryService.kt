package com.android.data.source.remote

import com.android.domain.model.Category
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CategoryService {

    @GET("categories/")
    fun getCategories():Single<List<Category>>

    @GET("categories/{id}")
    fun getCategory(@Path("id") id:Int?):Single<Category>

    @POST("categories/")
    fun createCategory(@Body category: Category):Single<Category>
}