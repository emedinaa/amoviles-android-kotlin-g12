package com.emedinaa.kotlinapp.model

import java.io.Serializable

/**
 * @author : Eduardo Medina
 * @since : 11/17/18
 * @see : https://developer.android.com/index.html
 */

open class MTypeEntity(){
    open fun isPlace()=false
    open fun isMovie()=false
}


class PlaceEntity(val id:Int,val title:String):MTypeEntity(){
    override fun isPlace()= true
    override fun isMovie()= false
}


class MovieEntity(val id:Int, val title:String,val desc:String, val price:Double,
                  val cartelera:Boolean):MTypeEntity(){
    override fun isPlace()= false
    override fun isMovie()= true
}

class Receipt(val id:Int, val title:String, val desc:String,val favorite:Boolean):Serializable