package com.emedinaa.kotlinapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emedinaa.kotlinapp.LogInActivity
import com.emedinaa.kotlinapp.MainActivity
import com.emedinaa.kotlinapp.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        ui()
    }

    private fun ui(){
        btnNext.setOnClickListener {
            goToMain()
        }

        iviBack.setOnClickListener {
            goToLogIn()
        }
    }

    private fun goToMain(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun goToLogIn(){
        startActivity(Intent(this, LogInActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
