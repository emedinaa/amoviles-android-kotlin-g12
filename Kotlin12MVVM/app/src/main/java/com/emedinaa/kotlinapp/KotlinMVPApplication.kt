package com.emedinaa.kotlinapp

import android.app.Application
import android.util.Log
import com.android.volley.VolleyLog
import com.android.volley.toolbox.Volley
import com.emedinaa.kotlinapp.data.Injection

class KotlinMVPApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        Injection.setUp(this)
        //volley
        VolleyLog.setTag("Volley")
        Log.isLoggable("Volley", Log.VERBOSE)
    }
}