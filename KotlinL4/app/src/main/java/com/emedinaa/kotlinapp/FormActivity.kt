package com.emedinaa.kotlinapp

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_form.*
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import android.app.DatePickerDialog.OnDateSetListener
import android.app.DatePickerDialog
import java.util.*


class FormActivity : AppCompatActivity() {

    private var localidad: String? = null
    private var genero = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
    }

    private fun ui(){
        lblfecnac.tag= null

        lblfecnac.setOnClickListener {
            //showDialog(100)
        }

        btnSignUp.setOnClickListener {
            //if(validateForm())
            /*if(validateFormError())
            {
                Toast.makeText(FormActivity@this, "Enviar al servidor...",
                    Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(FormActivity@this, "Revisar campos",
                    Toast.LENGTH_SHORT).show();
            }*/
        }
        
        /*rbGenero.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
            }
        }*/
        
        /*spLocation.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{

        }
        Log.v("CONSOLE", "spLocation" + parent?.adapter?.getItem(position))
        localidad = parent?.adapter?.getItem(position).toString()*/
    }

    private fun validateForm(): Boolean {

        val name = eteName.text.toString().trim()

        if (name.isEmpty()) return false


        //e-mail
        /*
            eteEmail.error = "E-mail inválido"
            return false*/

        //fecha nacimiento

        //localidad

        //genero
        Log.v("CONSOLE", "genero $genero")

        //notification
        //if(!chkNotification.isChecked) return false

        return true
    }


    /*override fun onCreateDialog(id: Int): Dialog? {
        when (id) {
            100 -> {
                val c = Calendar.getInstance()
                //c.add(Calendar.YEAR, 1)
                c.add(Calendar.YEAR,0)
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                return DatePickerDialog(this, OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    val s = dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year
                    Log.v("CONSOLE", "s $s")
                    lblfecnac.text=s
                    lblfecnac.tag=1
                }, year, month, day)
            }
        }
        return null
    }*/
}
