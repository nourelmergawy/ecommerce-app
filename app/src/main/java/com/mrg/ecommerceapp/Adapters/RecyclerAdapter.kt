package com.mrg.ecommerceapp.Adapters

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mrg.ecommerceapp.Models.Product
import com.mrg.ecommerceapp.Fragments.ProductPageFragment
import com.mrg.ecommerceapp.R
import com.mrg.ecommerceapp.databinding.HomeItemBinding

class RecyclerAdapter(var myList:ArrayList<Product>, var context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    lateinit var itemBinding: HomeItemBinding
    class ViewHolder(binding : HomeItemBinding) : RecyclerView.ViewHolder(binding.root) {
         var titletv:TextView
         var decriptiontv:TextView
         var productImage:ImageView
         var cardView : CardView
        init {
            titletv =binding.productTitle
            decriptiontv = binding.productDescription
            productImage = binding.productImage
            cardView = binding.cardItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemBinding = HomeItemBinding.inflate(LayoutInflater.from(parent.context))
        itemBinding.root
        return ViewHolder(
            itemBinding
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titletv.setText(myList.get(position).name)
        holder.decriptiontv.setText(myList.get(position).description)
        Glide
            .with(context)
            .load(myList.get(position).img1)
            .centerCrop()
            .placeholder(R.drawable.ic_loading_spinner)
            .into(holder.productImage)
        holder.cardView.setOnClickListener(View.OnClickListener {
            Log.d(TAG, "onBindViewHolder: im right in this ${position}")
            var productPageFragment :ProductPageFragment = ProductPageFragment(myList.get(position))
        })


    }

    override fun getItemCount(): Int {
        return myList.size
    }
    fun updateList(newList: ArrayList<Product>) {
        // on below line we are clCoinearing
        // our array list
//        newList.addAll(myList)
//        myList.clear()
        // on below line we are adding a
        // new list to our all  list.
        myList.addAll(newList)
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged()
    }
}