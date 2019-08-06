package com.emedinaa.kotlinapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.listeners.OnItemClickListener
import com.emedinaa.kotlinapp.model.Receipt


/**
 * @author : Eduardo Medina
 * @since : 11/17/18
 * @see : https://developer.android.com/index.html
 */
class ReceiptAdapter(val receiptList:List<Receipt>, val listener:OnItemClickListener?): RecyclerView.Adapter<ReceiptAdapter.Companion.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceiptAdapter.Companion.ViewHolder {
        val view= LayoutInflater.from(parent.context)
                .inflate(R.layout.row_recipe,parent,false)
        return  ReceiptAdapter.Companion.ViewHolder (view)
    }

    override fun getItemCount(): Int {
        return receiptList.size
    }


    override fun onBindViewHolder(holder:ReceiptAdapter.Companion.ViewHolder, position: Int) {
        val item: Receipt= receiptList[position]

        val title= receiptList[position].title
        val desc = receiptList[position].desc
        val favorite = receiptList[position].favorite

        holder.tviTitle.text=title
        holder.tviDesc.text= desc
        holder.iviFavorite.visibility = if(favorite)View.VISIBLE else View.GONE

        /*
        holder.itemView.setOnClickListener {
            listener?.onClickListener(position,item)
        }

        holder.iviFavorite.setOnClickListener {

        }*/
    }

    companion object {
        class ViewHolder(v:View ):RecyclerView.ViewHolder(v){
            val tviTitle:TextView=v.findViewById(R.id.tviTitle)
            val tviDesc:TextView= v.findViewById(R.id.tviDesc)
            val iviFavorite:ImageView= v.findViewById(R.id.iviFavorite)
        }
    }
}