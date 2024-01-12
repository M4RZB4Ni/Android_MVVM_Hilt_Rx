package com.android.presentation.photo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.domain.model.Product
import com.android.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val getPhotosUseCase: GetProductsUseCase
) : ViewModel() {

    val productListReceivedLiveData = MutableLiveData<List<Product>>()
    val isLoad = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }

    fun loadPhotos(category: String?) {
        if (category == null) return
        getPhotosUseCase.saveCategory(category)
        getPhotosUseCase.execute(
            onSuccess = {
                isLoad.value = true
                productListReceivedLiveData.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }
}
