package com.example.view_pagger

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyAdapter(mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {

    private val fragmentSize = 3
    override fun getItemCount(): Int {
        return fragmentSize
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                FragmentOne()
            }

            1 -> {
                FragmentTwo()
            }

            else -> {
                FragmentThree()
            }
        }
    }
}