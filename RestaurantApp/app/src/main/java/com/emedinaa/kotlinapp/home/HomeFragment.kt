package com.emedinaa.kotlinapp.home

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.data.DataCallback
import com.emedinaa.kotlinapp.data.DataInjector
import com.emedinaa.kotlinapp.model.Category
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 *
 */
class HomeFragment : Fragment() {
    //private var listener: OnFragmentInteractionListener? = null
    private var repository:CategoriesRepository = DataInjector.provideCategoriesRepository()
    private lateinit var adapter:CategoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        /*if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }*/
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //ui
        recyclerViewCategories.layoutManager= LinearLayoutManager(activity)

        //mock data
        /*val categoryList:MutableList<Category> = mutableListOf()
        categoryList.add(Category("1","Entradas",""))
        categoryList.add(Category("2","Segundos",""))
        categoryList.add(Category("3","Sopas",""))
        categoryList.add(Category("4","Postres",""))
        categoryList.add(Category("5","Vinos",""))*/
        adapter= CategoryAdapter(emptyList())
        recyclerViewCategories.adapter = adapter

        retrieveCategories()
    }

    private fun retrieveCategories(){
        repository.retrieveCategories(object :DataCallback<List<Category>>{
            override fun onError(errorMessage: String, exception: Exception) {

            }

            override fun onSuccess(data: List<Category>) {
                adapter.update(data)
            }
        })
    }
}
