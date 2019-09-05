package com.emedinaa.kotlinapp.data

import android.content.Context
import com.emedinaa.kotlinapp.dish.DishesRepository
import com.emedinaa.kotlinapp.home.CategoriesRepository
import com.emedinaa.kotlinapp.login.LogInRepository

object DataInjector {

    private lateinit var apiClient:ApiClient.ServicesApiInterface
    private lateinit var logInRepository:LogInRepository
    private lateinit var dishesRepository: DishesRepository
    private lateinit var categoriesRepository: CategoriesRepository

    fun setUp(context:Context){
        apiClient= ApiClient().build()

        logInRepository = LogInRepository(apiClient)
        dishesRepository = DishesRepository(apiClient)
        categoriesRepository = CategoriesRepository(apiClient)
    }

    fun provideLogInRepository():LogInRepository{
        return logInRepository
    }

    fun provideDishesRepository():DishesRepository{
        return dishesRepository
    }


    fun provideCategoriesRepository():CategoriesRepository{
        return categoriesRepository
    }
}