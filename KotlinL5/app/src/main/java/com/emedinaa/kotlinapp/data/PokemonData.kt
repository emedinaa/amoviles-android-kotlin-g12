package com.emedinaa.kotlinapp.data

import com.emedinaa.kotlinapp.model.Pokemon


/**
 * @author : Eduardo Medina
 * @since : 11/17/18
 * @see : https://developer.android.com/index.html
 */
object PokemonData {

    fun getPokemosList():List<Pokemon> {
        val pokemonList: MutableList<Pokemon> = arrayListOf()
        pokemonList.add(Pokemon(0,"Abra","","images/Abra.png"))
        pokemonList.add(Pokemon(0,"Arcanine","","images/Arcanine.png"))
        pokemonList.add(Pokemon(0,"Bulbasaur","","images/Bulbasaur.png"))
        pokemonList.add(Pokemon(0,"Caterpie","","images/Caterpie.png"))
        pokemonList.add(Pokemon(0,"Drowzee","","images/Drowzee.png"))
        pokemonList.add(Pokemon(0,"Exeggcute","","images/Exeggcute.png"))
        pokemonList.add(Pokemon(0,"Golem","","images/Golem.png"))
        pokemonList.add(Pokemon(0,"Lickitung","","images/Lickitung.png"))
        pokemonList.add(Pokemon(0,"Magmar","","images/Magmar.png"))
        pokemonList.add(Pokemon(0,"Nidorino","","images/Nidorino.png"))
        return pokemonList.toList()
    }
}