package com.mrg.ecommerceapp.Fragments

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mrg.ecommerceapp.Home
import com.mrg.ecommerceapp.R
import com.mrg.ecommerceapp.SignUP
import com.mrg.ecommerceapp.ViewModel
import com.mrg.ecommerceapp.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private lateinit var etEmail: EditText
    private lateinit var etpassword : EditText
    private lateinit var signinBtn : Button
    private lateinit var signUpBtn : Button
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater)
        //binding views
        etEmail = binding.emailItem
        etpassword = binding.passwordItem
        signinBtn = binding.signinBtn
        signUpBtn = binding.signupBtn
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(
            activity?.application!!)).get(ViewModel::class.java)

        signUpBtn.setOnClickListener {
            Log.d(ContentValues.TAG, "onCreate: i'm here")
            viewModel.fireBaseSignInAuth(etEmail.text.toString(),etpassword.text.toString(),
                activity?.applicationContext!!
            )

        }

        signinBtn.setOnClickListener {
            var email :String= etEmail.text.toString()
            var password : String = etpassword.text.toString()
            if(email != null && password != null){


            }
        }
        return binding.root
    }
    private fun updateUI(user: FirebaseUser?) {
        if (user != null){
//            var intent: Intent = Intent(applicationContext, Home::class.java)
//            intent.putExtra("user", user.toString())
//            startActivity(intent)
//            Log.d(TAG, "i', here : ${user}")

        }
    }


    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        if(currentUser != null){
////            updateUI(currentUser)
//        }
    }
}