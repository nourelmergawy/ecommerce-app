package com.mrg.ecommerceapp.Fragments

import android.net.Uri
import com.google.gson.annotations.SerializedName
import java.net.URI
import java.net.URL

data class Product(
//     @SerializedName("img3")
     var img3 :Uri =Uri.parse(""),
//     @SerializedName("amount")
     var amount :Int?=0,
//     @SerializedName("shipping")
     var shipping :Int?=0,
//     @SerializedName("price")
     var price :Int?=0,
//     @SerializedName("name")
     var name : String? = "",
//     @SerializedName("description")
     var description :String? = "",
//     @SerializedName("saler")
     var saler:String?= "",
//     @SerializedName("img2")
     var img2 : Uri=Uri.parse(""),
//     @SerializedName("img1")
     var img1:Uri=Uri.parse(""),

) {
}