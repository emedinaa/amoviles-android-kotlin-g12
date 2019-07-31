package com.emedinaa.kotlinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open abstract class BasicActivity : AppCompatActivity() {

    protected fun next(activityClass:Class<*>,bundle:Bundle?,destroy:Boolean?=true){

    }
}