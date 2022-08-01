package com.mrg.ecommerceapp.Fragments.Authentication

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.mrg.ecommerceapp.R
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
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView, SignUpFragment())
            transaction?.commit()
        }

        signinBtn.setOnClickListener {
            var email :String= etEmail.text.toString()
            var password : String = etpassword.text.toString()
             var task :Boolean
            if(email != null && password != null){

                viewModel.fireBaseSignInAuth(etEmail.text.toString(),etpassword.text.toString(),
                    activity?.applicationContext!!,this)

        }}

        return binding.root
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