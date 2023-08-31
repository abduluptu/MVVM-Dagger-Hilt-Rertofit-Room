package com.abdul.mvvm_dagger_hilt_rertofit_room.di

import com.abdul.mvvm_dagger_hilt_rertofit_room.retrofit.FakerAPI
import com.abdul.mvvm_dagger_hilt_rertofit_room.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//step6: create a network module to call network api

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesFakerApi(retrofit: Retrofit) : FakerAPI{
        return retrofit.create(FakerAPI::class.java)
    }
}