package com.mrg.ecommerceapp.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mrg.ecommerceapp.Fragments.CartFragment
import com.mrg.ecommerceapp.Fragments.HomeFragment
import com.mrg.ecommerceapp.Fragments.UserFragment

class ViewPagerAdapter(fragmentManager: FragmentManager ,var tabCount: Int) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0-> return UserFragment()
            1-> return HomeFragment()
            2-> return CartFragment()
            else -> return HomeFragment()
        }
    }
    override fun getPageTitle(position: Int): CharSequence {
        return "Tab " + (position + 1)
    }

}