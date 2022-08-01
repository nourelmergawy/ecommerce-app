package com.mrg.ecommerceapp.Fragments.HomeFragments

import android.content.ContentValues.TAG
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.mrg.ecommerceapp.Adapters.RecyclerAdapter
import com.mrg.ecommerceapp.Models.Product
import com.mrg.ecommerceapp.ViewModel
import com.mrg.ecommerceapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var  data:ArrayList<Product>
    private lateinit var adapter :RecyclerAdapter
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var textView : TextView
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel = ViewModel(activity?.application!!)
        setRecyclerView()
        viewModel.getProductData(data)
        viewModel.DataBaseListener(adapter,data)

        return binding.root
    }
    fun setRecyclerView(){
        var recyclerView :RecyclerView = binding.recyclerview
        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        val layoutManager = GridLayoutManager(activity?.applicationContext, 2, RecyclerView.VERTICAL, false)

        // at last set adapter to recycler view.
        recyclerView.layoutManager = layoutManager

        // ArrayList of class ItemsViewModel
        data = ArrayList<Product>()
//        initData()
        // This will pass the ArrayList to our Adapter
        adapter = RecyclerAdapter(data, activity?.applicationContext!!)

        // Setting the Adapter with the recyclerview
        recyclerView.adapter = adapter

    }
}