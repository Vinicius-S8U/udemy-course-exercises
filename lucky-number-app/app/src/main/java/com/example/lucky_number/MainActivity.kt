package com.example.lucky_number

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lucky_number.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun setOnClick(view: View){
        binding.mainActvBtn.setOnClickListener{
            var intent = Intent(this,LuckyNumberActivity::class.java)
            intent.putExtra("username",binding.mainActvEt.text.toString())
            startActivity(intent)
        }
    }
}