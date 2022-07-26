package com.mrg.ecommerceapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mrg.ecommerceapp.R
import com.mrg.ecommerceapp.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    lateinit var binding :FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCartBinding.inflate(inflater)

        // Inflate the layout for this fragment
        return binding.root
    }

}