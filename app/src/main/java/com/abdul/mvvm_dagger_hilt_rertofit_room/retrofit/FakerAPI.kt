package com.abdul.mvvm_dagger_hilt_rertofit_room.retrofit

import com.abdul.mvvm_dagger_hilt_rertofit_room.models.Product
import retrofit2.Response
import retrofit2.http.GET

//step2: create api interface

interface FakerAPI {

    @GET("products")
    suspend fun getProducts() : Response<List<Product>>
}