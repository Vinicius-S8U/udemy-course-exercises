package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displaySavedName()
        binding.btn.setOnClickListener{
            val enteredText = binding.editText.text.toString()
            saveNameInSharedPref(enteredText)
        }
    }

    private fun saveNameInSharedPref(text:String){
        val sharedPreferences = getSharedPreferences("Username", MODE_PRIVATE)
        sharedPreferences.edit().putString("name",text).apply()
    }

    private fun displaySavedName(){
        val sharedPreferences = getSharedPreferences("Username", MODE_PRIVATE)
        val lastUser = sharedPreferences.getString("name","")
        binding.tvUser.text = lastUser
    }
}