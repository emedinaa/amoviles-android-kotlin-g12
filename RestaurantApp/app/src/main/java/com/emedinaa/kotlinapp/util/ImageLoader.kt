package com.emedinaa.kotlinapp.util

import android.widget.ImageView

interface ImageLoader {

    fun load(url: String, imageView: ImageView)
    fun loadWithResize(url: String, imageView: ImageView,resize:Int)
    fun loadCircle(url: String, imageView: ImageView)
    fun loadLocal(path: String, imageView: ImageView)
}