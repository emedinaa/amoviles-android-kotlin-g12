package com.emedinaa.kotlinapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.model.NoteEntity
import com.emedinaa.kotlinapp.storage.NoteRaw
import com.emedinaa.kotlinapp.storage.NoteResponse
import com.emedinaa.kotlinapp.ui.dialog.NoteDialogFragment
import com.kotlin.samples.kotlinapp.storage.NoteApiClient
import com.kotlin.samples.kotlinapp.storage.NoteRepository
import kotlinx.android.synthetic.main.activity_edit_note.*
import kotlinx.android.synthetic.main.layout_loading.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditNoteActivity : AppCompatActivity(),NoteDialogFragment.DialogListener {

    private var call: Call<NoteResponse>?=null

    private var note: NoteEntity?=null
    private var name:String?=null
    private var desc:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        verifyExtras()
        populate()

        ui()
    }

    /*
     if(validateForm()){
                editNote()
            }
     */
    private fun ui(){
        btnEditNote.setOnClickListener {
            //editNote
        }


        btnDeleteNote.setOnClickListener {
            //showNoteDialog()
        }
    }

    /*
       call?.enqueue(object : Callback<NoteResponse> {
            override fun onFailure(call: Call<NoteResponse>, t: Throwable) {
                showErrorMessage(t.message)
            }

            override fun onResponse(call: Call<NoteResponse>, response: Response<NoteResponse>) {
                response?.body()?.let {
                    if(response.isSuccessful){
                        finish()
                    }else{
                        showErrorMessage(response.errorBody()?.string())
                    }
                }
            }
        })
     */
    private fun deleteNote(mNote:NoteEntity){
        call= NoteApiClient.build()?.deleteNote(mNote.id)

        call?.enqueue(object : Callback<NoteResponse> {
            override fun onFailure(call: Call<NoteResponse>, t: Throwable) {
                Log.v("CONSOLE"," onFailure $t")
            }

            override fun onResponse(call: Call<NoteResponse>, response: Response<NoteResponse>) {
                Log.v("CONSOLE"," onResponse ${response.body()}")
            }
        })
    }

    /*
           call?.enqueue(object : Callback<NoteResponse> {
            override fun onFailure(call: Call<NoteResponse>, t: Throwable) {
                hideLoading()
                showErrorMessage(t.message)
            }

            override fun onResponse(call: Call<NoteResponse>, response: Response<NoteResponse>) {
                hideLoading()
                response?.body()?.let {
                    if(response.isSuccessful){
                        finish()
                    }else{
                        showErrorMessage(response.errorBody()?.string())
                    }
                }
            }
        })
     */
    private fun editNote(){
       showLoading()
       val noteId= note?.id
       val raw= NoteRaw(noteId,name,desc,"001")
       call= NoteApiClient.build()?.updateNote(noteId,raw)

       call?.enqueue(object : Callback<NoteResponse> {
            override fun onFailure(call: Call<NoteResponse>, t: Throwable) {
                Log.v("CONSOLE"," onFailure $t")
            }

            override fun onResponse(call: Call<NoteResponse>, response: Response<NoteResponse>) {
                Log.v("CONSOLE"," onResponse ${response.body()}")
            }
        })
    }

    override fun onPause() {
        super.onPause()
        call?.cancel()
    }


    private fun showErrorMessage(error: String?) {
        Toast.makeText(this, "Error : $error", Toast.LENGTH_SHORT).show()
    }

    private fun validateForm():Boolean{
        name= eteName.text.toString()
        desc= eteDesc.text.toString()

        if(name.isNullOrEmpty()){
            return false
        }

        if(desc.isNullOrEmpty()){
            return false
        }

        return true
    }

    private fun populate(){
        note?.let {
            eteName.setText(it?.name)
            eteDesc.setText(it?.description)
        }
    }

    private fun showNoteDialog(){
        val noteDialogFragment= NoteDialogFragment()
        val bundle= Bundle()
        bundle.putString("TITLE","¿Deseas eliminar esta nota?")
        bundle.putInt("TYPE",100)

        noteDialogFragment.arguments= bundle
        noteDialogFragment.show(supportFragmentManager,"dialog")
    }

    override fun onPositiveListener(any: Any?, type: Int) {
        note?.let {
            //deleteNote(it)
        }
    }

    override fun onNegativeListener(any: Any?, type: Int) {}

    private fun verifyExtras(){
        intent?.extras?.let {
            note= it.getSerializable("NOTE") as NoteEntity
        }
    }

    private fun showLoading() {
        flayLoading.visibility= View.VISIBLE
    }

    private fun hideLoading() {
        flayLoading.visibility= View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
