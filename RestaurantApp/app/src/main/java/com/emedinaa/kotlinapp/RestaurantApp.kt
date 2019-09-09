package com.emedinaa.kotlinapp

import android.app.Application
import com.emedinaa.kotlinapp.data.DataInjector
import com.emedinaa.kotlinapp.util.Logger
import timber.log.Timber

class RestaurantApp: Application() {

    override fun onCreate() {
        super.onCreate()
        DataInjector.setUp(this)
        Logger.setUp()
    }
}