package com.abdul.mvvm_dagger_hilt_rertofit_room.di

import android.content.Context
import androidx.room.Room
import com.abdul.mvvm_dagger_hilt_rertofit_room.db.FakerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//step7: create a database module to get database

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesFakerDB(@ApplicationContext context: Context): FakerDB {
        return Room.databaseBuilder(context, FakerDB::class.java, "FakerDB").build()
    }
}