package com.emedinaa.kotlinapp.dish

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.kotlinapp.model.Category
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.model.Dish

class DishAdapter(var categoryList:List<Dish>):RecyclerView.Adapter<DishAdapter.Companion.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent?.context)
            .inflate(R.layout.row_dish,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = categoryList[position]
        holder?.textViewTitle?.text=entity.name
        holder?.textViewDesc?.text=entity.desc
        holder?.textViewPrice?.text="S/. ${entity.price}"
    }

    override fun getItemCount(): Int = categoryList.size

    fun update(data:List<Dish>){
        categoryList= data
        notifyDataSetChanged()
    }

    companion object {
        class ViewHolder(v:View ):RecyclerView.ViewHolder(v){
            val imageViewDish:ImageView=v.findViewById(R.id.imageViewDish)
            val textViewTitle:TextView=v.findViewById(R.id.textViewTitle)
            val textViewDesc:TextView=v.findViewById(R.id.textViewDesc)
            val textViewPrice:TextView=v.findViewById(R.id.textViewPrice)
        }
    }
}