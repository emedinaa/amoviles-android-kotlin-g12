package com.emedinaa.kotlinapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val onClickListener= View.OnClickListener {
        var mActivity:Class<*>?=null
        mActivity?.let {
            goToView(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun goToView(mActivity:Class<*>){
        startActivity(Intent(this,mActivity))
    }
}
