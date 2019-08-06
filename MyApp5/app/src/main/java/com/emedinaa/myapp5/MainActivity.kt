package com.emedinaa.myapp5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //origen de datos
    private val mDays:Array<String> = arrayOf("Lunes",
        "Martes","Miercoles","Jueves", "Viernes",
        "Sábado", "Domingo")

    private val mLanguages:Array<String> =
            arrayOf("Python","Ruby",
                "C++","Kotlin","Scala",
                "Swift", "Groovy")

    private val entityList:MutableList<Entity>
            = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        entityList.add(Entity(1,"Python",""))
        entityList.add(Entity(2,"Ruby",""))
        entityList.add(Entity(3,"C++",""))
        entityList.add(Entity(4,"Kotlin",""))
        entityList.add(Entity(5,"Scala",""))
        entityList.add(Entity(5,"Swift",""))
        entityList.add(Entity(6,"Groovy",""))
        entityList.add(Entity(7,"Javascript",""))
        entityList.add(Entity(8,"Dart",""))
        entityList.add(Entity(9,"Go",""))
        entityList.add(Entity(10,"PHP",""))
        entityList.add(Entity(11,"C#",""))
        entityList.add(Entity(12,"Java",""))

        //val myAdapter= MyAdapter(this,mLanguages)
        val myAdapter= MyAdapter(this,entityList.toList())

        listView.adapter= myAdapter

        // event
        listView.setOnItemClickListener { parent, view, position, id ->
            val entity = entityList[position]
            showItem(position,entity)
        }
    }

    private fun showItem(position:Int,entity:Entity){
        Toast.makeText(this, "position :$position id : ${entity.id}  title : ${entity.title}",
            Toast.LENGTH_LONG).show()
    }
}
