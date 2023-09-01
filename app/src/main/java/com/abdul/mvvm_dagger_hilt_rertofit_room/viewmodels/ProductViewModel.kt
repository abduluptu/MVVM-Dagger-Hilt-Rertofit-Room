package com.abdul.mvvm_dagger_hilt_rertofit_room.viewmodels

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdul.mvvm_dagger_hilt_rertofit_room.models.Product
import com.abdul.mvvm_dagger_hilt_rertofit_room.repository.ProductRepository
import com.abdul.mvvm_dagger_hilt_rertofit_room.utils.ApiResponse
import com.abdul.mvvm_dagger_hilt_rertofit_room.utils.Util
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

//step8: create a view model to get products from repository

@HiltViewModel
class ProductViewModel @Inject constructor(@SuppressLint("StaticFieldLeak") @ApplicationContext private val context: Context, private val repository: ProductRepository) :
    ViewModel() {

    //val productsLiveData: LiveData<ApiResponse<List<Product>>>
       // get() = repository.products

    private val _products = MutableLiveData<ApiResponse<List<Product>>>()
    val products: LiveData<ApiResponse<List<Product>>> = _products

    //to handle loading state
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

   /* init {
        viewModelScope.launch {
            delay(10000)
            repository.getProducts()
            Log.d("SOHA", "ViewModel" +   repository.getProducts())
        }
    }*/

    fun fetchProducts(){
        viewModelScope.launch {
            _isLoading.value = true
            _products.value = ApiResponse.Loading
            if(Util.isNetworkAvailable(context)){
                val response = repository.getProducts()
                _products.value = response
            }else{
                _products.value = ApiResponse.Error("No internet connection")
            }
            _isLoading.value = false
        }
    }
}