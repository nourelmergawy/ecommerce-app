package com.mrg.ecommerceapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mrg.ecommerceapp.databinding.ActivityHomeBinding
import com.mrg.ecommerceapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var textView : TextView

        var view:View
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        view = binding.root
        textView = binding.textViewfr

        return view
    }

}