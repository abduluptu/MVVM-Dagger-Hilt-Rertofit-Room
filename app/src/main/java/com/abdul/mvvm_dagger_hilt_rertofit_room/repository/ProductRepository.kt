package com.abdul.mvvm_dagger_hilt_rertofit_room.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abdul.mvvm_dagger_hilt_rertofit_room.db.FakerDB
import com.abdul.mvvm_dagger_hilt_rertofit_room.models.Product
import com.abdul.mvvm_dagger_hilt_rertofit_room.retrofit.FakerAPI
import com.abdul.mvvm_dagger_hilt_rertofit_room.utils.ApiResponse
import com.abdul.mvvm_dagger_hilt_rertofit_room.utils.Constants.TAG
import javax.inject.Inject

//step8: create a repository class to provide implementation for api & db

class ProductRepository @Inject constructor(
    private val fakerAPI: FakerAPI,
    private val fakerDB: FakerDB
) {

   /* private val _products = MutableLiveData<List<Product>>()

    val products: LiveData<List<Product>>
        get() = _products*/



    suspend fun getProducts(): ApiResponse<List<Product>> {
        try {
            val response = fakerAPI.getProducts()
            if (response.isSuccessful) { //&& response.body() != null
                val result = response.body()
                if (result != null) {
                    //save products into database
                    fakerDB.getFakerDAO().addProducts(result) //check here for result
                    return ApiResponse.Success(result)

                }
                //save products into database
               // fakerDB.getFakerDAO().addProducts(response.body()!!) //check here for result
                //add products to LiveData
               // _products.postValue(response.body())
            }
            return ApiResponse.Error("Failed to fetch data")

        } catch (e: Exception) {
            return ApiResponse.Error(e.message ?: "An error occurred")
        }


        /*val response = fakerAPI.getProducts()
        Log.d(TAG, "Repository" +  response.toString())
        if (response.isSuccessful ) { //&& response.body() != null
            val result = response.body()
            if (result != null){
                ApiResponse.Success(result)
            }
            //save products into database
            fakerDB.getFakerDAO().addProducts(response.body()!!) //check here for result
            //add products to LiveData
            _products.postValue(response.body())
        }else{
            Log.d(TAG, "Repository" +  "Error")
        }*/
    }
}