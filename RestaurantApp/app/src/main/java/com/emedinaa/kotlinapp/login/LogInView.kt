package com.emedinaa.kotlinapp.login

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.data.DataCallback
import com.emedinaa.kotlinapp.data.DataInjector
import com.emedinaa.kotlinapp.model.User
import kotlinx.android.synthetic.main.layout_loading.view.*
import kotlinx.android.synthetic.main.layout_login_session.view.*
import kotlinx.android.synthetic.main.layout_login_view.view.*

class LogInView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr){

    private  var logInRepository: LogInRepository=DataInjector.provideLogInRepository()
    init {
        addView(View.inflate(context, R.layout.layout_login_view,null))
        addView(View.inflate(context, R.layout.layout_login_session,null))
        addView(View.inflate(context, R.layout.layout_loading,null))

        layoutLogInSession.visibility= View.GONE
        layoutLogIn.visibility= View.VISIBLE
        layoutLoading.visibility= View.GONE

        buttonLogIn.setOnClickListener {
            logIn()
        }

        btnLogOut.setOnClickListener {
            showLogInView()
        }
    }

    private fun logIn(){
        showLoadingView()
        val username:String= editTextEmail.text.toString().trim()
        val password:String= editTextPassword.text.toString().trim()

        logInRepository.logIn(username,password,object:DataCallback<User>{
            override fun onError(errorMessage: String, exception: Exception) {
                hideLoadingView()
                showError(errorMessage)
            }

            override fun onSuccess(data: User) {
                hideLoadingView()
                textViewEmail.text= data.username
                showLogInViewSession()
            }
        })
    }

    private fun showError(errorMessage:String){
        Toast.makeText(context,errorMessage,Toast.LENGTH_SHORT).show()
    }

    private fun showLogInView(){
        layoutLogInSession.visibility= View.GONE
        layoutLogIn.visibility= View.VISIBLE
    }

    private fun showLogInViewSession(){
        layoutLogInSession.visibility= View.VISIBLE
        layoutLogIn.visibility= View.GONE
    }

    private fun showLoadingView(){
        layoutLoading.visibility= View.VISIBLE
    }

    private fun hideLoadingView(){
        layoutLoading.visibility= View.GONE
    }
}