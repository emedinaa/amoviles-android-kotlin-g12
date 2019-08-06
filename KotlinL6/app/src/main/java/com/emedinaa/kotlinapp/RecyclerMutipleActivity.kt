package com.emedinaa.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.kotlinapp.adapters.MultipleAdapter
import com.emedinaa.kotlinapp.data.MultipleData
import com.emedinaa.kotlinapp.model.MTypeEntity
import kotlinx.android.synthetic.main.activity_recycler_mutiple.*

class RecyclerMutipleActivity : AppCompatActivity() {

    private var mLayoutManager: RecyclerView.LayoutManager?=null
    private lateinit var mutipleAdapter: MultipleAdapter
    private lateinit var mutipleList:List<MTypeEntity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_mutiple)

        mLayoutManager= LinearLayoutManager(this) //LinearLayoutManager.VERTICAL
        recyclerViewMutiple.layoutManager= mLayoutManager

        mutipleList = MultipleData.getData()
        mutipleAdapter= MultipleAdapter(this,mutipleList)

        recyclerViewMutiple.adapter= mutipleAdapter
    }
}
