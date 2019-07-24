package com.emedinaa.kotlinapp.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.emedinaa.kotlinapp.R

class SelectionDialog:DialogFragment() {

    private lateinit var mContext: Context

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(mContext)

        builder.setTitle(R.string.pick_color)
            .setItems(R.array.colors_array){ _, which:Int ->
                log("item $which")
            }
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext= context
    }

    private fun log(message: String) {
        Log.d("CONSOLE", message)
    }
}