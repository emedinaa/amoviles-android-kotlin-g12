package com.emedinaa.kotlinapp.login

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.emedinaa.kotlinapp.R

class LogInView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr){

    init {
        addView(View.inflate(context, R.layout.layout_login_view,null))
    }
}