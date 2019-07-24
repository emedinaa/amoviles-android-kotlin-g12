package com.emedinaa.kotlinapp.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.emedinaa.kotlinapp.R
import android.util.Log
import android.view.LayoutInflater
import android.widget.EditText

class CustomDialog:DialogFragment() {

    private lateinit var mContext:Context
    private var mListener:CustomDialogListener?=null

    private var username: String = ""
    private var password: String = ""
    private var eteUsername: EditText? = null
    private var etePassword: EditText? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(mContext)

        val inflater = activity?.layoutInflater

        val customView = inflater?.inflate(R.layout.fragment_custom_dialog, null)
        eteUsername = customView?.findViewById(R.id.eteUsername)
        etePassword = customView?.findViewById(R.id.etePassword)

        builder.setView(customView)
            .setPositiveButton(R.string.signin) { _, _ ->

                if (validateForm()) {
                    val message = String.format("username $username password $password")
                    Log.v("CONSOLE", message)

                    mListener?.onDialogPositive(message)
                }

                log("Dialog aceptar")
            }
            .setNegativeButton(R.string.scancel){ _, _ ->
                // FIRE ZE MISSILES!
                log("Dialog cancelar")
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

    private fun log(message: String) {
        Log.d("CONSOLE", message)
    }
}