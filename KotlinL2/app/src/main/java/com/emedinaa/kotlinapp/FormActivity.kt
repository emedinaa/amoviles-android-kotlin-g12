package com.emedinaa.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    private var name:String=""
    private var email:String=""
    private var password1:String=""
    private var password2:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        ui()
    }

    private fun ui(){
        butSignUp.setOnClickListener {

            Log.v("CONSOLE", "click")
            //validar formulario

            //mostrar mensaje
            //showMessage()
        }
    }

    private fun validateForm():Boolean{

        //capturar valores
        name= eteName.text.toString()

        //validar campos vacios
        //eteName.error="Ingresar el nombre"

        //validar email
        //eteEmail.error="E-mail inválido"

        //validar passwords
        // etePassword1.error="Ingresar el password"

        //validar si los passwords son iguales
        // etePassword2.error="No conciden las contraseñas"
        return false
    }


    private fun showMessage(){
        val builder:AlertDialog.Builder= AlertDialog.Builder(this).apply {
            title=""
            setMessage("Enviando al servidor...")
            setPositiveButton("Aceptar") { _, _ ->

            }
        }
        val dialog:AlertDialog= builder.create()
        dialog.show()
    }

    private fun clear(){
        eteName.error=null
        eteEmail.error=null
        etePassword1.error=null
        etePassword2.error=null
    }
}
