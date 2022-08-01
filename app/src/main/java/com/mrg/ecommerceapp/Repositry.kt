package com.mrg.ecommerceapp

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.mrg.ecommerceapp.Adapters.RecyclerAdapter
import com.mrg.ecommerceapp.Models.Product
import com.mrg.ecommerceapp.Models.User
import com.mrg.ecommerceapp.Ui.Home

class Repositry(private var database: DatabaseReference) {
    private lateinit var auth: FirebaseAuth

    fun fireBaseSignInAuth(email: String, password: String, context: Context,fragment: Fragment){
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email!!, password!!)
            .addOnCompleteListener(OnCompleteListener {
                if (it.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "signInWithEmail:success")
                    updateUi(fragment,auth)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "signInWithEmail:failure", it.exception)
                    Toast.makeText(
                        context, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            })
    }

    fun fireBaseSignUpAuth(
        email: String,
        password: String,
        fragment : Fragment,
        context: Context
    ) {
        auth.createUserWithEmailAndPassword(email!!, password!!)
            .addOnCompleteListener(OnCompleteListener {
                if (it.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "createUserWithEmail:success")
                    updateUi(fragment,auth)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "createUserWithEmail:failure", it.exception)
                    Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun updateUi(fragment: Fragment,auth: FirebaseAuth) {
//        Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_home22)
        fragment.activity.let {
            val intent = Intent (it, Home::class.java)
            val user = auth.currentUser
                // Name, email address, and profile photo Url
                val name = user?.displayName
                val email = user?.email
                val photoUrl = user?.photoUrl
                val photoint = photoUrl.toString()
            var bundle :Bundle =  Bundle();
            bundle.putSerializable("auth", User(name,email,photoint));
            intent.putExtras(bundle)
            it?.startActivity(intent)

        }
    }


    fun DataBaseListener(adapter : RecyclerAdapter,data:ArrayList<Product>){
        database.child("products").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                adapter.updateList(data)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }

    fun getProductData(data:ArrayList<Product>){
        database.child("products").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for (item in snapshot.children){

                    var img3 : Uri =  Uri.parse(item.child("img3").getValue().toString())
                    var amount :Int?= item.child("amount").getValue().toString().toInt()
                    var shipping :Int?=item.child("shipping").getValue().toString().toInt()
                    var price :Int?=item.child("price").getValue().toString().toInt()
                    var name : String? = item.child("name").getValue().toString()
                    var description :String? = item.child("description").getValue().toString()
                    var saler:String?=item.child("saler").getValue().toString()
                    var img2 : Uri = Uri.parse(item.child("img2").getValue().toString())
                    var img1: Uri = Uri.parse(item.child("img1").getValue().toString())
                    Log.d(ContentValues.TAG, "onDataChange: ${data.size}")
                    data.add(Product(img3!!,amount,shipping,price,name,description,saler,img2!!,img1!!))
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

}


