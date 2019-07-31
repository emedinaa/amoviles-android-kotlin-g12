package com.emedinaa.kotlinapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.adapters.SimpleListAdapter
import com.emedinaa.kotlinapp.toast
import kotlinx.android.synthetic.main.activity_simple_list.*

/*
       1. Data Provider : List, ArrayList, Array
       2. View Container : ListView, GridView, RecyclerView
       3. Entity : Entity class
       4. Row : view Xml
       5. Adapter: ArrayAdapter , BaseAdapter, CursorAdapter
       6. Set Adapter to the View container

*/

class SimpleListActivity : AppCompatActivity() {

    private val mDays:Array<String> = arrayOf("Monday", "Tuesday","Wednesday","Thursday","Friday",
            "Saturday", "Sunday")

    private val mMonths= arrayOf("January", "February","March","April","May",
            "June", "July", "August","September", "October", "November","December")

    private val mPlanets= arrayOf("Mercury", "Venus","Earth","Mars","Pluto",
            "Jupiter", "Saturn", "Uranus","Neptune")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list)

        //adapter
        //val arrayAdapter= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mMonths)

        //val arrayAdapter1= ArrayAdapter<String>(this,R.layout.row,mMonths)

        val adapter= SimpleListAdapter(this, mDays)

        listViewMovies.adapter= adapter
        //listViewMovies.adapter= arrayAdapter1
        //listViewMovies.adapter= adapter

        //events
        listViewMovies.setOnItemClickListener { adapterView, view, position, l ->
            val item= "$position : ${adapterView.adapter.getItem(position)}"
            toast(item,Toast.LENGTH_SHORT)
        }
    }
}
