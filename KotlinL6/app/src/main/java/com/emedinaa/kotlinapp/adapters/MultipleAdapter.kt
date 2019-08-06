package com.emedinaa.kotlinapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.model.MTypeEntity
import com.emedinaa.kotlinapp.model.MovieEntity
import com.emedinaa.kotlinapp.model.PlaceEntity

/**
 * @author : Eduardo Medina
 * @since : 11/17/18
 * @see : https://developer.android.com/index.html
 */
class MultipleAdapter(val context:Context, val mTypeList:List<MTypeEntity>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater= LayoutInflater.from(parent.context)

        return when (viewType) {
            MOVIE -> {
                val movieView = inflater.inflate(com.emedinaa.kotlinapp.R.layout.row_movie_list, parent, false)
                 MovieViewHolder(movieView)
            }
            PLACE -> {
                val placeView = inflater.inflate(com.emedinaa.kotlinapp.R.layout.row_place, parent, false)
                 PlaceViewHolder(placeView)
            }
            else -> {
                val defaultView = inflater.inflate(com.emedinaa.kotlinapp.R.layout.row_movie_list, parent, false)
                 MovieViewHolder(defaultView)
            }
        }
    }

    override fun getItemCount(): Int {
        return mTypeList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            MOVIE -> {
                val movieViewHolder = holder as MovieViewHolder
                renderItemMovie(movieViewHolder, position)
            }
            PLACE -> {
                val placeViewHolder = holder as PlaceViewHolder
                renderPlaceMovie(placeViewHolder, position)
            }
            else -> {
                val defaultViewHolder = holder as MovieViewHolder
                renderItemMovie(defaultViewHolder, position)
            }
        }
    }

    private fun renderPlaceMovie(placeViewHolder: PlaceViewHolder, position: Int) {
        val placeEntity = mTypeList[position] as PlaceEntity?

        placeEntity?.let {
            placeViewHolder.tviTitle.text=it.title
        }
    }

    private fun renderItemMovie(movieViewHolder: MovieViewHolder, position: Int) {
        val movieEntity = mTypeList.get(position) as MovieEntity?
        
        movieEntity?.let {
            movieViewHolder.tviName.text = it.title
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (mTypeList[position].isMovie()) {
            return MOVIE
        } else if (mTypeList[position].isPlace()) {
            return PLACE
        }
        return -1
    }

    internal inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tviName: TextView=itemView.findViewById(com.emedinaa.kotlinapp.R.id.tviName) as TextView
    }

    internal inner class PlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tviTitle: TextView= itemView.findViewById(com.emedinaa.kotlinapp.R.id.tviTitle) as TextView
    }

    companion object {
        private const val MOVIE = 0
        private const val PLACE = 1
    }
}