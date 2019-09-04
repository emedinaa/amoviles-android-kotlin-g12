package com.emedinaa.kotlinapp

import android.app.Application
import com.emedinaa.kotlinapp.data.DataInjector

class RestaurantApp: Application() {

    override fun onCreate() {
        super.onCreate()
        DataInjector.setUp(this)
    }
}