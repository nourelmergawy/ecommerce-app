package com.mrg.ecommerceapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrg.ecommerceapp.databinding.FragmentHomeBinding
import com.mrg.ecommerceapp.databinding.HomeItemBinding

class RecyclerAdapter(var myList:ArrayList<Mylist>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    lateinit var itemBinding: HomeItemBinding
    class ViewHolder(binding : HomeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        lateinit var titletv:TextView
        lateinit var decriptiontv:TextView
        lateinit var productImage:ImageView
        init {
            titletv =binding.productTitle
            decriptiontv = binding.productDescription
            productImage = binding.productImage
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
        holder.titletv.setText(myList.get(position).etitle)
        holder.decriptiontv.setText(myList.get(position).edecription)
        holder.productImage.setImageResource(myList.get(position).eimg)

    }

    override fun getItemCount(): Int {
        return myList.size
    }
}