package com.emedinaa.kotlinapp.data

import com.emedinaa.kotlinapp.model.MTypeEntity
import com.emedinaa.kotlinapp.model.MovieEntity
import com.emedinaa.kotlinapp.model.PlaceEntity

object MultipleData {

    fun getData():List<MTypeEntity>{
        val dataList:MutableList<MTypeEntity> = arrayListOf()
        dataList.add(PlaceEntity(0,"Alcazar"))
        dataList.add(MovieEntity(0,"UNA PAREJA DISPAREJA","",0.0,false))
        dataList.add(MovieEntity(0,"ENEMIGO EN LA RED","",0.0,false))
        dataList.add(MovieEntity(0,"Batman","",0.0,true))
        dataList.add(MovieEntity(0,"Tiburón","",0.0,false))

        dataList.add(PlaceEntity(1,"Brasil"))
        dataList.add(MovieEntity(0,"Tiburón","",0.0,false))
        dataList.add(MovieEntity(0,"Batman","",0.0,true))
        dataList.add(MovieEntity(0,"Harry Potter","",0.0,false))
        dataList.add(MovieEntity(0,"LA REINA DE KATWE","",0.0,false))
        dataList.add(MovieEntity(0,"ROBERT EL MUÑECO POSEIDO","",0.0,true))

        return  dataList.toList()
    }
}