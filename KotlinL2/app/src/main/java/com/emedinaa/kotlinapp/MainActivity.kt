package com.emedinaa.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1.setOnClickListener {
            goToActivity(CalculatorActivity::class.java)
        }

        textView2.setOnClickListener {
            goToActivity(GalleryActivity::class.java)
        }

        textView2.setOnClickListener {
            goToActivity(FormActivity::class.java)
        }
    }

    private fun goToActivity(activity:Class<*>){
        startActivity(Intent(this,activity))
    }
}
