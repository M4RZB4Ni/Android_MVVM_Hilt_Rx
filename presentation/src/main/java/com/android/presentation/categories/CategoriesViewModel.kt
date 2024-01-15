package com.android.presentation.categories

import androidx.lifecycle.ViewModel
import com.android.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CategoriesViewModel @Inject constructor(private val getCategoriesUseCase: GetProductsUseCase) : ViewModel() {

}