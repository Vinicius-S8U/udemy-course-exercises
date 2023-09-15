package com.example.fragments_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragments_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainBtn1.setOnClickListener {
            val fragment1 = Fragment1()
            val fragmentTransaction = supportFragmentManager.beginTransaction()

            fragmentTransaction.replace(
                R.id.main_frame1,
                fragment1
            ).commit()
        }

        binding.mainBtn2.setOnClickListener {
            val fragment2 = Fragment2()
            val fragmentTransaction = supportFragmentManager.beginTransaction()

            fragmentTransaction.replace(
                R.id.main_frame2,
                fragment2
            ).commit()
        }
    }
}