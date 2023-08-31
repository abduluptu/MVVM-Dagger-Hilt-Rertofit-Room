package com.abdul.mvvm_dagger_hilt_rertofit_room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abdul.mvvm_dagger_hilt_rertofit_room.models.Product

//step3: create a database class

@Database(entities = [Product::class], version = 1)
abstract class FakerDB :  RoomDatabase(){

    //step4.1: to access FakerDAO
    abstract fun getFakerDAO() : FakerDAO
}