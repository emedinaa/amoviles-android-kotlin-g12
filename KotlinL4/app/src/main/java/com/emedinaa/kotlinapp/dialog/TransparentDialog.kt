package com.emedinaa.kotlinapp.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.emedinaa.kotlinapp.R
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.graphics.drawable.ColorDrawable
import androidx.annotation.Nullable


class TransparentDialog:DialogFragment() {

    private lateinit var mContext:Context
    private var mListener:CustomDialogListener?=null

    private var username: String = ""
    private var password: String = ""

    private var eteUsername: EditText? = null
    private var etePassword: EditText? = null
    private var tviCancel:View?=null
    private var tviOk:View?=null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(mContext)

        val inflater = activity?.layoutInflater

        val customView = inflater?.inflate(com.emedinaa.kotlinapp.R.layout.fragment_transparent_dialog, null)
        eteUsername = customView?.findViewById(com.emedinaa.kotlinapp.R.id.eteUsername)
        etePassword = customView?.findViewById(com.emedinaa.kotlinapp.R.id.etePassword)
        tviCancel=  customView?.findViewById(com.emedinaa.kotlinapp.R.id.tviCancel)
        tviOk=  customView?.findViewById(com.emedinaa.kotlinapp.R.id.tviOk)

        builder.setView(customView)

        tviCancel?.setOnClickListener{
            dismiss()
            mListener?.onDialogNegative("")
        }

        tviOk?.setOnClickListener{
            if (validateForm()) {
                dismiss()
                val message = String.format("username $username password $password")
                Log.v("CONSOLE", message)

                mListener?.onDialogPositive(message)
            }
        }

        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext= context

        if (context is CustomDialogListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement CustomDialogListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    private fun validateForm(): Boolean {
        username = eteUsername?.text.toString().trim()
        password = etePassword?.text.toString().trim()

        if(username.isEmpty()) return false
        if(password.isEmpty()) return false

        return true
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dialog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
    }

    private fun log(message: String) {
        Log.d("CONSOLE", message)
    }
}