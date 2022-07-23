package com.mrg.ecommerceapp

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mrg.ecommerceapp.databinding.ActivityMainBinding

class  MainActivity : AppCompatActivity() {
//    private  var task: Boolean = false
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var etEmail: EditText
    private lateinit var etpassword :EditText
    private lateinit var signinBtn :Button
    private lateinit var signUpBtn :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding views
        etEmail = binding.emailItem
        etpassword = binding.passwordItem
        signinBtn = binding.signinBtn
        signUpBtn = binding.signupBtn
        auth = Firebase.auth
        signinBtn.setOnClickListener {
            var email :String= etEmail.text.toString()
            var password : String = etpassword.text.toString()
            // Initialize Firebase Auth
            auth.signInWithEmailAndPassword(email!! , password!!)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }
        }


    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            finish();
            startActivity(getIntent())
        }
    }


    private fun updateUI(user: FirebaseUser?) {
        if (user != null){
            var intent: Intent = Intent(applicationContext,SignUP::class.java)
            startActivity(intent)
        }
    }
}