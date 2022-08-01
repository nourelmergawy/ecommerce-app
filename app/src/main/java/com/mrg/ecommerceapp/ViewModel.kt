package com.mrg.ecommerceapp

import android.app.Application
import android.content.Context
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mrg.ecommerceapp.Adapters.RecyclerAdapter
import com.mrg.ecommerceapp.Models.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel (application: Application) : AndroidViewModel(application){
    val repositry:Repositry
    init {
        repositry= Repositry(DataBase.getFbDataBase(application))
    }
    fun fireBaseSignInAuth(email:String,password:String,context: Context,fragment: Fragment){
        viewModelScope.launch (Dispatchers.IO){
           repositry.fireBaseSignInAuth(email,password,context,fragment)
        }
    }
    fun fireBaseSignUpAuth(email:String,password:String,fragment:Fragment,context: Context){
        viewModelScope.launch (Dispatchers.IO){
            repositry.fireBaseSignUpAuth(email,password,fragment,context)
        }
    }

    fun DataBaseListener(adapter : RecyclerAdapter, data:ArrayList<Product>){
        viewModelScope.launch (Dispatchers.IO){
            repositry.DataBaseListener(adapter,data)
        }
    }
    fun getProductData(data:ArrayList<Product>){
        viewModelScope.launch (Dispatchers.IO){
            repositry.getProductData(data)
        }
    }
}