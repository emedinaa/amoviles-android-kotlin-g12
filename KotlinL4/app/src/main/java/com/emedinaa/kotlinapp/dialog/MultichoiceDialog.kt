package com.emedinaa.kotlinapp.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.emedinaa.kotlinapp.R

class MultichoiceDialog: DialogFragment() {

    private var mSelectedItems:MutableList<Int> = mutableListOf()
    private lateinit var mContext: Context

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(mContext)

        builder.setTitle(R.string.pick_toppings)
            .setMultiChoiceItems(R.array.toppings, null){dialog:DialogInterface,  which:Int,
                isChecked:Boolean ->
                if (isChecked) {
                    // If the user checked the item, add it to the selected items
                    mSelectedItems.add(which)
                } else if (mSelectedItems.contains(which)) {
                    // Else, if the item is already in the array, remove it
                    mSelectedItems.remove(Integer.valueOf(which))
                }
            }
            .setPositiveButton(R.string.ok) { _, _ ->
                renderSelectedItems()
            }
            .setNegativeButton(R.string.scancel){ _, _ ->
                log("Dialog cancelar")
            }
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext= context
    }


    private fun renderSelectedItems() {
        log("items $mSelectedItems")
    }

    private fun log(message: String) {
        Log.d("CONSOLE", message)
    }
}