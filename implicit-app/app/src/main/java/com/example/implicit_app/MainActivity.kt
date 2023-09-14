package com.example.implicit_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.implicit_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun goToYoutube(view: View){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=kVgy1GSDHG8&ab_channel=NicholasT."))
        startActivity(intent)
    }
}