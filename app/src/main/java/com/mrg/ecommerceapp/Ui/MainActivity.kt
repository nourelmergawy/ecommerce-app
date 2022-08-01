package com.mrg.ecommerceapp.Ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mrg.ecommerceapp.databinding.ActivityMainBinding
class  MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
// TODO: setNav Graph

    }

}