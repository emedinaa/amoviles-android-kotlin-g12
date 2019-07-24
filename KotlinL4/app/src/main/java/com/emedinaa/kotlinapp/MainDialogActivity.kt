package com.emedinaa.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.emedinaa.kotlinapp.dialog.*
import kotlinx.android.synthetic.main.activity_main_dialog.*


class MainDialogActivity : AppCompatActivity(),CustomDialogListener {
    override fun onAction(obj: Any) {

    }

    override fun onDialogPositive(obj: Any) {
        Toast.makeText(this,"Custom Dialog "+  getString(R.string.signin)+" "+obj.toString(),Toast.LENGTH_SHORT).show()
    }

    override fun onDialogNegative(obj: Any) {
        Toast.makeText(this,"Custom Dialog "+getString(R.string.scancel),Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_dialog)

        btnDialog.setOnClickListener {
            //showSimpleDialog()
            //showSelectionDialog()
            //showMultichoiceDialog()
            showCustomDialog()
            //showTransparentDialog()
        }
    }

    private fun showSimpleDialog() {
        val dialog = SimpleDialog()
        dialog.show(supportFragmentManager, "SimpleDialog")
    }

    private fun showSelectionDialog() {
        val dialog = SelectionDialog()
        dialog.show(supportFragmentManager, "SelectionDialog")
    }

    private fun showMultichoiceDialog() {
        val dialog = MultichoiceDialog()
        dialog.show(supportFragmentManager, "MultichoiceDialog")
    }

    private fun showCustomDialog() {
        val dialog = CustomDialog()
        dialog.show(supportFragmentManager, "CustomDialog")
    }

    private fun showTransparentDialog() {
        val dialog = TransparentDialog()
        dialog.show(supportFragmentManager, "TransparentDialog")
    }
}
