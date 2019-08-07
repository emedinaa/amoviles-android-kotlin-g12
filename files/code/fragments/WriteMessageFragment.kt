package com.emedinaa.kotlinapp.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.listeners.MessageListener
import android.widget.EditText


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class WriteMessageFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private var listener: MessageListener? = null

    private var eteMessage: EditText? = null
    private var btnSend: Button? = null
    private var message: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_write_message, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        eteMessage = view?.findViewById<View>(R.id.eteMessage) as EditText
        btnSend = view?.findViewById<View>(R.id.btnSend) as Button

        btnSend?.setOnClickListener {
            message= eteMessage?.text.toString().trim()
            listener?.recibiryEnviardesdeFragment(message)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MessageListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement MessageListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                WriteMessageFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
