package com.mrg.ecommerceapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mrg.ecommerceapp.R
import com.mrg.ecommerceapp.databinding.FragmentHomeBinding
import com.mrg.ecommerceapp.databinding.FragmentUserBinding

class UserFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var fragmentUserBinding :FragmentUserBinding
        fragmentUserBinding = FragmentUserBinding.inflate(layoutInflater)

        val user = Firebase.auth.currentUser
        user?.let {
            // Name, email address, and profile photo Url
            val name = user.displayName
            val email = user.email
            val photoUrl = user.photoUrl
            var nameTv = fragmentUserBinding.userName
            var emailTv = fragmentUserBinding.email
            nameTv.setText(name)
            emailTv.setText(email)
        }

        return fragmentUserBinding.root
    }

}