package com.mrg.ecommerceapp

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mrg.ecommerceapp.databinding.ActivitySignUpBinding

class SignUP : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var etEmail: EditText
    private lateinit var etpassword : EditText
    private lateinit var signUpBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //binding views
        etEmail = binding.emailItem
        etpassword = binding.passwordItem
        signUpBtn = binding.signupBtn

        // Initialize Firebase Auth
        auth = Firebase.auth
        var myProg :String? = intent.getSerializableExtra("user").toString()

        Toast.makeText(this, myProg, Toast.LENGTH_SHORT).show()
        val user = Firebase.auth.currentUser
        signUpBtn.setOnClickListener {
            var email :String= etEmail.text.toString()
            var password : String = etpassword.text.toString()

            auth.createUserWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }
        }

    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null){
            var intent: Intent = Intent(applicationContext,Home::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }
}