package com.emedinaa.kotlinapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.dish.DishFragment
import com.emedinaa.kotlinapp.home.HomeFragment
import com.emedinaa.kotlinapp.order.OrderFragment
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private val homeFragment= HomeFragment()
    private val dishFragment= DishFragment()
    private val orderFragment= OrderFragment()
    private val chefFragment= ChefFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        bottomNavigationView.setOnNavigationItemSelectedListener {

            var fragment:Fragment?=null

            when(it.itemId){
                R.id.action_home -> fragment= homeFragment
                R.id.action_dishes -> fragment= dishFragment
                R.id.action_orders -> fragment= orderFragment
                R.id.action_chef -> fragment= chefFragment
            }

            fragment?.let {
                changeFragment(it)
            }
            return@setOnNavigationItemSelectedListener true
        }

        //first tab
        changeFragment(homeFragment)
    }

    private fun changeFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,fragment,null)
            commit()
        }
    }
}
