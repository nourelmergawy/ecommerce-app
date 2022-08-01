package com.mrg.ecommerceapp.Fragments.HomeFragments

import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mrg.ecommerceapp.Models.User
import com.mrg.ecommerceapp.databinding.FragmentUserBinding


class UserFragment : Fragment() {
   private lateinit var fragmentUserBinding :FragmentUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentUserBinding = FragmentUserBinding.inflate(layoutInflater)
//        val bundle = Intent.getextras
//        val user: User? = bundle!!.getSerializable("auth") as User?

        var nameTv = fragmentUserBinding.userName
        var emailTv = fragmentUserBinding.email
//        nameTv.setText(user?.name)
//        emailTv.setText(user?.email)

        return fragmentUserBinding.root
    }

}