package com.emedinaa.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val  message= "Hello kotlin!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setOnClickListener {
            Log.v("CONSOLE", message)
            showMessage(message)
        }
    }

    private fun showMessage(message:String){
        Toast.makeText(this, message,Toast.LENGTH_LONG).show()
    }
}
