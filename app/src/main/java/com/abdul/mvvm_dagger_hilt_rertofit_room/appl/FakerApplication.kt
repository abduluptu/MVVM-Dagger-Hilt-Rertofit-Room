package com.abdul.mvvm_dagger_hilt_rertofit_room.appl

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//step5: This application class create Dagger code

@HiltAndroidApp
class FakerApplication : Application(){

    override fun onCreate() {
        super.onCreate()

    }
}