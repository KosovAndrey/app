package com.foodtracker.app.presentation.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.foodtracker.app.domain.model.ProductItem
import com.foodtracker.app.domain.usecase.GetProductsUseCase
import com.foodtracker.app.domain.usecase.GetTokenUseCase
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    getTokenUseCase: GetTokenUseCase,
) : ViewModel() {

    private val token = getTokenUseCase.execute()

    private var _responseProducts: MutableLiveData<List<ProductItem?>> =
        MutableLiveData<List<ProductItem?>>()
    val responseProducts: LiveData<List<ProductItem?>> = _responseProducts

    fun getProducts() {
        viewModelScope.launch {
            _responseProducts.value = getProductsUseCase.execute(token!!)
        }
    }

//    private val token = getTokenUseCase.execute()
//
//    //val actionPosition: MutableLiveData<Int> = MutableLiveData<Int>()
//    private var _responseProducts: MutableLiveData<List<ProductItem?>> =
//        MutableLiveData<List<ProductItem?>>()
//    val responseProducts: LiveData<List<ProductItem?>> = _responseProducts
//
//    fun getProducts() {
//        viewModelScope.launch {
//            _responseProducts.value = getProductsUseCase.execute(token!!)
//        }
//    }

}