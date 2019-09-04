package com.emedinaa.kotlinapp.data

import android.content.Context
import com.emedinaa.kotlinapp.login.LogInRepository

object DataInjector {

    private lateinit var apiClient:ApiClient.ServicesApiInterface

    fun setUp(context:Context){
        apiClient= ApiClient().build()
    }

    fun provideLogInRepository():LogInRepository{
        return LogInRepository(apiClient)
    }
}