package com.mrg.ecommerceapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.OnSwipe
import com.mrg.ecommerceapp.R
import com.mrg.ecommerceapp.databinding.FragmentProductPageBinding

class ProductPageFragment(prod: Product) : Fragment() {
    lateinit var binding : FragmentProductPageBinding
    lateinit var productTitle : TextView
    lateinit var productImg : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentProductPageBinding.inflate(inflater)
        productTitle = binding.titleItem
        productImg = binding.imgItem

//        productImg.setImageURI()
            return binding.root

    }
}