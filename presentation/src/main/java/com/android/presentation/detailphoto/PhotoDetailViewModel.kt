package com.android.presentation.detailphoto

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.domain.model.Product
import com.android.domain.usecase.GetProductDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(
    private val getProductDetailUseCase: GetProductDetailUseCase
) : ViewModel() {

    val productData = MutableLiveData<Product>()
    private val isLoad = MutableLiveData<Boolean>()
    val isInBasket = MutableLiveData<Boolean>()

    init {
        isLoad.value = false
    }

    fun getDetail(id: Int?) {
        if (id == null) return
        getProductDetailUseCase.saveProductId(id)
        getProductDetailUseCase.execute(
            onSuccess = {
                isLoad.value = true
                productData.value = it
            },
            onError = {
                it.printStackTrace()
            }
        )
    }

    fun updateFavoriteStatus() {
        productData.value?.let { product ->
            if (isInBasket.value == true) {
                getProductDetailUseCase.removeFromBasket(product)
            } else {
                getProductDetailUseCase.addToBasket(product)
            }
            isInBasket.value?.let {
                isInBasket.value = !it
            }
        }
    }

    fun checkFavoriteStatus(productId: Int) {
        isInBasket.value = getProductDetailUseCase.isInBasket(productId)
    }
}
