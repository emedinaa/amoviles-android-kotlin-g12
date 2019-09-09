package com.emedinaa.kotlinapp.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.chef.ChefFragment
import com.emedinaa.kotlinapp.data.Cart
import com.emedinaa.kotlinapp.dish.DishFragment
import com.emedinaa.kotlinapp.home.HomeFragment
import com.emedinaa.kotlinapp.order.OrderFragment
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private val homeFragment= HomeFragment()
    private val dishFragment= DishFragment()
    private val orderFragment= OrderFragment()
    private val chefFragment= ChefFragment()

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        dashboardViewModel= ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        dashboardViewModel.cartNotification.observe(this,notificationObserver)

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

    override fun onResume() {
        super.onResume()
        if(!Cart.isEmpty()){
            showNotification(Cart.getItems().size)
        }
    }

    private fun changeFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout,fragment,null)
            commit()
        }
    }

    private fun showNotification(nNumber:Int){
        if(nNumber==0){
            bottomNavigationView.removeBadge(R.id.action_orders)
        }else{
            val badge= bottomNavigationView.showBadge(R.id.action_orders).apply {
                number= nNumber
            }
            badge.backgroundColor = Color.WHITE
            badge.badgeTextColor= Color.RED
        }
    }

    private var notificationObserver= Observer<Int>{
       bottomNavigationView.showBadge(R.id.action_orders).apply {
           number= it
       }
    }
}
