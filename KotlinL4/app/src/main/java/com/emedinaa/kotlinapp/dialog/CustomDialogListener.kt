package com.emedinaa.kotlinapp.dialog

interface CustomDialogListener {

    fun onAction(obj: Any)
    fun onDialogPositive(obj: Any)
    fun onDialogNegative(obj: Any)
}