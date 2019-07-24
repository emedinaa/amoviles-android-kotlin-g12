package com.emedinaa.kotlinapp.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.emedinaa.kotlinapp.R
import android.util.Log


class SimpleDialog:DialogFragment() {

    private lateinit var mContext:Context

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(mContext)

        builder.setTitle("Aviso !")
            .setMessage(R.string.dialog_fire_missiles)
            .setPositiveButton(R.string.fire) { _, _ ->
                // FIRE ZE MISSILES!
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
    }

    private fun log(message: String) {
        Log.d("CONSOLE", message)
    }
}