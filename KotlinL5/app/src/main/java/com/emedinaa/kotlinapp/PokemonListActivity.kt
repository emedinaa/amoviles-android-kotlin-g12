package com.emedinaa.kotlinapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.adapters.PokemonAdapter
import com.emedinaa.kotlinapp.data.PokemonData
import com.emedinaa.kotlinapp.model.Pokemon
import com.kotlin.samples.kotlinapp.listeners.RecyclerClickListener
import com.kotlin.samples.kotlinapp.listeners.RecyclerTouchListener
import kotlinx.android.synthetic.main.activity_pokemon_list.*

class PokemonListActivity : AppCompatActivity() {

    companion object {
        const  val DEFAULT_SPANCOUNT=3
    }

    private lateinit var pokemonAdapter: PokemonAdapter
    private var pokemonList= emptyList<Pokemon>()
    private var mLayoutManager: RecyclerView.LayoutManager?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        //mLayoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)//LinearLayoutManager.VERTICAL
        mLayoutManager= GridLayoutManager(this, 3)
        recyclerViewPokemon.layoutManager= mLayoutManager

        //events
        recyclerViewPokemon.addOnItemTouchListener(RecyclerTouchListener(
                this,recyclerViewPokemon,object:RecyclerClickListener{
            override fun onClick(view: View, position: Int) {
                val pokemon= pokemonList[position]
                Log.v("CONSOLE", "pokemon $pokemon")
            }

            override fun onLongClick(view: View, position: Int) {

            }
        }
        ))
        loadData()
        renderPokemonList()
    }

    private fun renderPokemonList(){
        pokemonAdapter= PokemonAdapter(this,pokemonList)
        recyclerViewPokemon.adapter= pokemonAdapter
    }

    private fun loadData(){
        pokemonList= PokemonData.getPokemosList()
    }
}
