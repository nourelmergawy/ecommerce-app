package com.mrg.ecommerceapp

import android.content.ContentValues.TAG
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.mrg.ecommerceapp.databinding.ActivityHomeBinding
import com.mrg.ecommerceapp.databinding.ActivitySignUpBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout : TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}