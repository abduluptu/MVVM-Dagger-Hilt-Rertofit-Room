package com.abdul.mvvm_dagger_hilt_rertofit_room.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdul.mvvm_dagger_hilt_rertofit_room.models.Product
import com.abdul.mvvm_dagger_hilt_rertofit_room.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

//step8: create a view model to get products from repository

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository) :
    ViewModel() {

    val productsLiveData: LiveData<List<Product>>
        get() = repository.products

    init {
        viewModelScope.launch {
            delay(10000)
            repository.getProducts()
            Log.d("SOHA", "ViewModel" +   repository.getProducts())
        }
    }
}