package com.emedinaa.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emedinaa.kotlinapp.model.Receipt
import kotlinx.android.synthetic.main.activity_receipt_details.*

class ReceiptDetailsActivity : AppCompatActivity() {

    private var receipt:Receipt?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipt_details)

        verifyExtras()

        populate()
    }

    private fun populate(){
        receipt?.let {
            textViewTitle.text= it.title
            textViewDesc.text= it.desc
        }
    }

    private fun verifyExtras(){
        receipt = intent?.extras?.getSerializable("RECEIPT") as? Receipt
    }
}
