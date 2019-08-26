package com.emedinaa.kotlinapp.model

import java.io.Serializable

data class User(val email:String,
                val userName:String,
                val lastName:String)

data class Category(val id:Int,
                    val name:String):Serializable

data class Dish(val id:Int, val category:Int,
                val name:String,val desc:String, val price:Double, val photo:String):Serializable

data class Order(val id:Int,
                 val amount:Int, val dishId:Int,
                 val dishName:String, val dishPrice:Double):Serializable

data class Cart(val id:String, val userId:String,val orderList:
List<Order>)


