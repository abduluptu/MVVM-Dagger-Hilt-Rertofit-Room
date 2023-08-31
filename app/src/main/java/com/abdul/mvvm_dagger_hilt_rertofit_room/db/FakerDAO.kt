package com.abdul.mvvm_dagger_hilt_rertofit_room.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abdul.mvvm_dagger_hilt_rertofit_room.models.Product

//step4: create a dao interface to perform database operations

@Dao
interface FakerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(productItem: List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getProducts() : List<Product>
}