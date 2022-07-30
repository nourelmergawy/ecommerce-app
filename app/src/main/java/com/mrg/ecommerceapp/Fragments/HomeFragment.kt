package com.mrg.ecommerceapp.Fragments

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
import com.beust.klaxon.Klaxon
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.GsonBuilder
import com.mrg.ecommerceapp.Adapters.RecyclerAdapter
import com.mrg.ecommerceapp.databinding.FragmentHomeBinding
import kotlin.math.log


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var database: DatabaseReference
    private lateinit var  data:ArrayList<Product>
    private lateinit var adapter :RecyclerAdapter
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

        database = Firebase.database.reference
        var recyclerView :RecyclerView = binding.recyclerview
//        // this creates a vertical layout Manager
//        recyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)
        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
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

        getProductData()
        database.child("products").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                adapter.updateList(data)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
        return binding.root
    }
    private fun initData(){

        var uri :Uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/ecommerce-bbbe1.appspot.com/o/1-3.jpg?alt=media&token=30efd439-4a4c-405b-979d-844b494a2fd8")
        data.add(Product(uri,5,7,16,"dfdvdffvdv","vdfvdfvdf","fff",uri,uri))
        data.add(Product(uri,5,7,16,"dfdvdffvdv","vdfvdfvdf","fff",uri,uri))
        data.add(Product(uri,5,7,16,"dfdvdffvdv","vdfvdfvdf","fff",uri,uri))

    }
    private fun getProductData(){
        database.child("products").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for (item in snapshot.children){
//                        Log.d(TAG, "onDataChange2: ${item}")
//                        Log.d(TAG, "onDataChange3: ${item.value}")
                    var img3 :Uri =  Uri.parse(item.child("img3").getValue().toString())
//                    Log.d(TAG, "onDataChange: ${item.child("amount").getValue() as Int?}")
                    var amount :Int?= item.child("amount").getValue().toString().toInt()
                    var shipping :Int?=item.child("shipping").getValue().toString().toInt()
                    var price :Int?=item.child("price").getValue().toString().toInt()
                    var name : String? = item.child("name").getValue().toString()
                    var description :String? = item.child("description").getValue().toString()
                    var saler:String?=item.child("saler").getValue().toString()
                    var img2 : Uri=Uri.parse(item.child("img2").getValue().toString())
                    var img1:Uri=Uri.parse(item.child("img1").getValue().toString())
                    Log.d(TAG, "onDataChange: ${data.size}")
                    data.add(Product(img3!!,amount,shipping,price,name,description,saler,img2!!,img1!!))
//                    for (i :Int in 0..10){
//                        Log.d(TAG, "onDataChange: ${img3}")
//                        Log.d(TAG, "onDataChange: ${amount}")
//                        Log.d(TAG, "onDataChange: ${shipping}")
//                        Log.d(TAG, "onDataChange: ${name}")
//                        Log.d(TAG, "onDataChange: ${description}")
//                        Log.d(TAG, "onDataChange: ${saler}")
//                        Log.d(TAG, "onDataChange: ${img2}")
//                        Log.d(TAG, "onDataChange: ${img1}")
//
//                    }
                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}