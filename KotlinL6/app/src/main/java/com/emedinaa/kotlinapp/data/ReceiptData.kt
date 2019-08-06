package com.emedinaa.kotlinapp.data

import com.emedinaa.kotlinapp.model.Receipt

object ReceiptData {

    fun getData():List<Receipt>{
        val dataList:MutableList<Receipt> = arrayListOf()
        dataList.add(Receipt(100,"Adobo de chancho",
            "El adobo es un estilo de preparación proveniente de Europa; pero en Perú..",
            true))
        dataList.add(Receipt(101,"Aguadito",
            "Otro platillo de larga data, una sopa espesa contradictoriamente a su nombre..",
            false))
        dataList.add(Receipt(102,"Ajiaco de papas",
            "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..",
            true))
        dataList.add(Receipt(103,"Ají de gallina",
            "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..",
            true))
        dataList.add(Receipt(104,"Ajiaco de papas",
            "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..",
            false))
        dataList.add(Receipt(105,"Aguadito",
            "Otro platillo de larga data, una sopa espesa contradictoriamente a su nombre",
            false))

        dataList.add(Receipt(106,"Adobo de chancho",
            "El adobo es un estilo de preparación proveniente de Europa; pero en Perú",
            true))


        return  dataList.toList()
    }
}