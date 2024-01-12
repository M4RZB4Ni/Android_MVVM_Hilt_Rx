package com.android.presentation.album

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.domain.model.Category
import com.android.domain.usecase.GetCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**To store & manage UI-related data in a lifecycle conscious way!
 * this class allows data to survive configuration changes such as screen rotation
 * by interacting with [GetCategoryUseCase]
 *
 * */
@HiltViewModel
class CategoryViewModel @Inject constructor(private val getCategoryUseCase: GetCategoryUseCase) :
    ViewModel() {

        val categoriesReceivedLiveData = MutableLiveData<List<Category>>()
    val isLoad = MutableLiveData<Boolean>()
    private val categoryData = MutableLiveData<List<Category>>()

    init {
        isLoad.value = false
    }

    val category: List<Category>? get() = categoryData.value

    fun set(categories: List<Category>) = run { categoryData.value = categories }

    fun loadAlbums() {
        getCategoryUseCase.execute(
            onSuccess = {
                isLoad.value = true
                categoriesReceivedLiveData.value = it
            },
            onError = {
                it.printStackTrace()
            },
        )
    }
}
