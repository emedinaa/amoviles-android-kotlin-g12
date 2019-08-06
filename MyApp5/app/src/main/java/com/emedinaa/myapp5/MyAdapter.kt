package com.emedinaa.myapp5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(
    context:Context,
    private val data:List<Entity>):BaseAdapter() {

    private val mInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?,
                         parent: ViewGroup?): View {
        //cargar la vista (row)
        val view = mInflater.inflate(R.layout.row,parent,false)
        //asociar entidad con los elementos de la celda
        val entity= data[position]
        view.findViewById<TextView>(R.id.textView).text=entity.title
        return view
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return data.size
    }
}