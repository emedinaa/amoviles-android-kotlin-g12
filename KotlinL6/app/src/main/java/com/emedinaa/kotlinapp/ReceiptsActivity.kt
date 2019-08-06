package com.emedinaa.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.kotlinapp.adapters.ReceiptAdapter
import com.emedinaa.kotlinapp.data.ReceiptData
import com.emedinaa.kotlinapp.listeners.OnItemClickListener
import com.emedinaa.kotlinapp.model.Receipt
import com.kotlin.samples.kotlinapp.listeners.RecyclerClickListener
import com.kotlin.samples.kotlinapp.listeners.RecyclerTouchListener
import kotlinx.android.synthetic.main.activity_receipts.*

class ReceiptsActivity : AppCompatActivity(),OnItemClickListener {

    private var mLayoutManager: RecyclerView.LayoutManager?=null
    private lateinit var receiptAdapter: ReceiptAdapter
    private lateinit var receiptList:List<Receipt>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receipts)

        mLayoutManager= LinearLayoutManager(this)//LinearLayoutManager.VERTICAL
        recyclerViewReceipt.layoutManager= mLayoutManager
        recyclerViewReceipt.addOnItemTouchListener(RecyclerTouchListener(this,recyclerViewReceipt,object :
        RecyclerClickListener{
            override fun onClick(view: View, position: Int) {
                goToReceiptDetails(position)
            }

            override fun onLongClick(view: View, position: Int) {

            }
        }))

        receiptList = ReceiptData.getData()
        receiptAdapter= ReceiptAdapter(receiptList,this)
        recyclerViewReceipt.adapter= receiptAdapter
    }

    private fun goToReceiptDetails(position: Int){
        val receipt = receiptList[position]
        val bundle:Bundle = Bundle()
        bundle.putSerializable("RECEIPT", receipt)

        val intent= Intent(this, ReceiptDetailsActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun onClickListener(position: Int, data: Any?) {
        goToReceiptDetails(position)
    }
}
