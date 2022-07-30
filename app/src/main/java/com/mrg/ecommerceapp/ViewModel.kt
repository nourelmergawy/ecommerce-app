package com.mrg.ecommerceapp

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel (application: Application) : AndroidViewModel(application){
    val repositry:Repositry
    init {
        repositry= Repositry()
    }
    fun fireBaseSignInAuth(email:String,password:String,context: Context):Boolean{
        viewModelScope.launch (Dispatchers.IO){
            repositry.fireBaseSignInAuth(email,password,context)
        }
        return repositry.task
    }
}