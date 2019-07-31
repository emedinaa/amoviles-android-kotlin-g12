package com.emedinaa.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.samples.kotlinapp.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //events
        btn1.setOnClickListener {
            goToView(SimpleListActivity::class.java)
        }

        btn2.setOnClickListener {
            goToView(SimpleGridActivity::class.java)
        }

        btn3.setOnClickListener {
            goToView(MovieListActivity::class.java)
        }

        btn4.setOnClickListener {
            goToView(MovieGridActivity::class.java)
        }

        btn5.setOnClickListener {
            goToView(PeopleActivity::class.java)
        }

        btn6.setOnClickListener {
            goToView(ProductActivity::class.java)
        }

        btn7.setOnClickListener {
            goToView(PokemonListActivity::class.java)
        }
    }

    private fun goToView(activity:Class<*>) {

        //1.Contexto de la vista donde te encuentras
        //2. Conocer la pantalla de destino
        startActivity(Intent(this, activity))
    }
}
