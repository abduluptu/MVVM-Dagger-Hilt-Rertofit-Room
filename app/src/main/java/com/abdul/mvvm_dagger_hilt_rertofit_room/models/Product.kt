package com.abdul.mvvm_dagger_hilt_rertofit_room.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//step1: create model class from json response

/*
@Entity
class Product : ArrayList<ProductItem>(){

}*/

@Entity
data class Product(
    val category: String,
    val description: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)
