package com.mrg.ecommerceapp.Ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.tabs.TabLayout
import com.mrg.ecommerceapp.Adapters.ViewPagerAdapter
import com.mrg.ecommerceapp.R
import com.mrg.ecommerceapp.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbar= binding.appBar
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        setupTabLayout()
        setupViewPager()

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
       return super.onCreateOptionsMenu(menu!!)

    }
    private fun setupViewPager() {
        binding.viewPager.apply {
            adapter = ViewPagerAdapter(supportFragmentManager, binding.appBarLayout.tabCount)
            addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.appBarLayout))
        }
    }

    private fun setupTabLayout() {
        binding.appBarLayout.apply {

            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.position?.let {
                        binding.viewPager.currentItem = it
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            })
        }
    }
}