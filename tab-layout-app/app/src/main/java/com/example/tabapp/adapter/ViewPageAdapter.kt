package com.example.tabapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tabapp.fragments.BooksFragment
import com.example.tabapp.fragments.GamesFragment
import com.example.tabapp.fragments.MoviesFragment

class ViewPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                BooksFragment()
            }

            1 -> {
                GamesFragment()
            }
            else -> {
                MoviesFragment()
            }
        }
    }
}