package com.mrg.ecommerceapp

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import com.mrg.ecommerceapp.databinding.ActivitySignUpBinding

class SignUP : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var etEmail: EditText
    private lateinit var etpassword : EditText
    private lateinit var etusername : EditText
    private lateinit var signUpBtn : Button
    private lateinit var profileImg : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding views
        etEmail = binding.emailItem
        etpassword = binding.passwordItem
        signUpBtn = binding.signupBtn
        etusername = binding.userItem
        profileImg= binding.imgPicker

        //hide items
        etusername.isVisible = false
        profileImg.isVisible = false
        // Initialize Firebase Auth
        auth = Firebase.auth

        signUpBtn.setText("next")
        signUpBtn.setOnClickListener {
            val user = Firebase.auth.currentUser
            var email :String= etEmail.text.toString()
            var password : String = etpassword.text.toString()
            when (signUpBtn.text.toString()) {
                "next"->
                    auth.createUserWithEmailAndPassword(email!!, password!!)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success")
                                signUpBtn.setText("signup")
                                etusername.isVisible = true
                                profileImg.isVisible = true
                                profileImg.setOnClickListener {
                                    ImagePicker.with(this)
                                        .crop()	    			//Crop image(Optional), Check Customization for more option
                                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                                        .maxResultSize(1080, 1080)
                                        .createIntent { intent ->
                                            startForProfileImageResult.launch(intent)
                                        }//Final image resolution will be less than 1080 x 1080(Optional)

                                }
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                                Toast.makeText(baseContext, "Authentication failed.",Toast.LENGTH_SHORT).show()
                                updateUI(null)
                            }
                        }
                "signup" -> updateUI(user)
                else -> { // Note the block
                    Toast.makeText(baseContext, "final signup failed." ,Toast.LENGTH_LONG).show()
                }
            }

        }
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null){
            var intent: Intent = Intent(applicationContext,Home::class.java)
            startActivity(intent)
        }
    }
    private fun addUserProflie(username: String, uri: Uri) {
        val user = Firebase.auth.currentUser

        val profileUpdates = userProfileChangeRequest {
            displayName = username
            photoUri = Uri.parse(uri.toString())
        }
        user!!.updateProfile(profileUpdates)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "User profile updated.")
                    updateUI(user)
                }
            }

    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK) {
//            //Image Uri will not be null for RESULT_OK
//            val uri: Uri = data?.data!!
//            // Use Uri object instead of File to avoid storage permissions
//            profileImg.setImageURI(uri)
//            addUserProflie(etusername.text.toString(),uri)
//        } else if (resultCode == ImagePicker.RESULT_ERROR) {
//
//            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
//        }
//    }
    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!

                var mProfileUri = fileUri
                profileImg.setImageURI(fileUri)
                addUserProflie(etusername.text.toString(),mProfileUri)

            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }
}