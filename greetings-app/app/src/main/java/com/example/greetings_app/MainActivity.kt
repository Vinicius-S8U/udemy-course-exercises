package com.example.greetings_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.greetings_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setOnClick()
    }

    private fun setOnClick(){
        binding.mainBtn.setOnClickListener{
            var inputTxt = binding.mainEt.text

            Toast.makeText(this, "Hello $inputTxt",Toast.LENGTH_LONG).show()
        }
    }
}