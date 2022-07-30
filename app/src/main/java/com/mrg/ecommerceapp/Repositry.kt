package com.mrg.ecommerceapp

import android.content.ContentValues
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class Repositry {
    private lateinit var auth: FirebaseAuth
    var task = false

    fun fireBaseSignInAuth(email:String,password:String,context: Context):Boolean{
        // Initialize Firebase Auth
        auth.signInWithEmailAndPassword(email!!, password!!)
            .addOnCompleteListener(OnCompleteListener {
                if (it.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    task = it.isSuccessful
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "signInWithEmail:failure", it.exception)
                    Toast.makeText(context, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    task = false
                }
            })
        return task
    }
}