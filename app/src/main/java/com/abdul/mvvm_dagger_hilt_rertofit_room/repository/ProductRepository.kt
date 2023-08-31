package com.abdul.mvvm_dagger_hilt_rertofit_room.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abdul.mvvm_dagger_hilt_rertofit_room.db.FakerDB
import com.abdul.mvvm_dagger_hilt_rertofit_room.models.Product
import com.abdul.mvvm_dagger_hilt_rertofit_room.retrofit.FakerAPI
import javax.inject.Inject

//step8: create a repository class to provide implementation for api & db

class ProductRepository @Inject constructor(
    private val fakerAPI: FakerAPI,
    private val fakerDB: FakerDB
) {

    private val _products = MutableLiveData<List<Product>>()

    val products: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts() {
        val result = fakerAPI.getProducts()
        Log.d("SOHA", "Repository" +  result.toString())
        if (result.isSuccessful && result.body() != null) {
            //save products into database
            fakerDB.getFakerDAO().addProducts(result.body()!!) //check here for result
            //add products to LiveData
            _products.postValue(result.body())
        }else{
            Log.d("SOHA", "Repository" +  "Error")
        }
    }
}