package com.example.tabapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.tabapp.adapter.ViewPageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    val tabsArray = arrayOf("Books","Games","Movies")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewpagger)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        val myAdapter = ViewPageAdapter(
            supportFragmentManager,
            lifecycle
        )

        viewPager.adapter = myAdapter

        TabLayoutMediator(tabLayout,viewPager){
            tab ,position -> tab.text = tabsArray[position]
        }.attach()
    }
}