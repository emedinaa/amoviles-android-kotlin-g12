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
            goToView(RecyclerMutipleActivity::class.java)
        }

        btn2.setOnClickListener {
        }

        btn3.setOnClickListener {

        }

        btn4.setOnClickListener {

        }

        btn5.setOnClickListener {

        }

        btn6.setOnClickListener {

        }

        btn7.setOnClickListener {

        }
    }

    private fun goToView(activity:Class<*>) {

        //1.Contexto de la vista donde te encuentras
        //2. Conocer la pantalla de destino
        startActivity(Intent(this, activity))
    }
}
