package com.emedinaa.kotlinapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.adapters.SimpleGridAdapter
import com.emedinaa.kotlinapp.toast
import kotlinx.android.synthetic.main.activity_simple_grid.*

class SimpleGridActivity : AppCompatActivity() {

    private val mDays:Array<String> = arrayOf("Monday", "Tuesday","Wednesday","Thursday","Friday",
            "Saturday", "Sunday")

    private val mMonths= arrayOf("January", "February","March","April","May",
            "June", "July", "August","September", "October", "November","December")

    private val mPlanets= arrayOf("Mercury", "Venus","Earth","Mars","Pluto",
            "Jupiter", "Saturn", "Uranus","Neptune")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_grid)

        //adapter
        val adapter= SimpleGridAdapter(this, mMonths)
        gridViewSimple.adapter= adapter

        //events
        gridViewSimple.setOnItemClickListener { adapterView, view, position, l ->
            val item= "$position : ${adapterView.adapter.getItem(position)}"
            toast(item, Toast.LENGTH_SHORT)
        }
    }
}
