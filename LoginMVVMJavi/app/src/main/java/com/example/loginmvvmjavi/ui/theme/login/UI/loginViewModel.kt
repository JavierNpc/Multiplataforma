package com.example.loginmvvmjavi.ui.theme.login.UI

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.intellij.lang.annotations.Pattern

class LoginViewModel : ViewModel(){
    private val _email  = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _password  = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _isloginEnabled  = MutableLiveData<Boolean>()
    val isloginEnabled : LiveData<Boolean> = _isloginEnabled

    fun onPasswordChange(password: String){
        _password.value = password
    }

    fun onEmailChange(email: String){
        _email.value = email
    }

    fun onIsLoginEnableChange(isloginEnabled: Boolean){
        _isloginEnabled.value = isloginEnabled
    }

    fun onLogingChange(email: String, password: String){
        _email.value = email
        _password.value = password
        _isloginEnabled.value = enableLogin(email,password)
    }

    private fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()
        &&
        password.length > 8

}