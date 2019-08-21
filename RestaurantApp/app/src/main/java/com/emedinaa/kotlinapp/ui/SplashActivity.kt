package com.emedinaa.kotlinapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emedinaa.kotlinapp.R
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    companion object {
        const val SPLASH_TIME:Long=3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val timer= Timer()
        timer.schedule(timerTask {
            goToDashboard()
        }, SPLASH_TIME)
    }

    private fun goToDashboard(){
        val intent= Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }
}
