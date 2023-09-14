package com.example.explicitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.explicitapp.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        val age = bundle?.get("age")
        val ageNotDeprecated = bundle?.getInt("age")

        Toast.makeText(this, "Your current age is $age", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "Your current age is $ageNotDeprecated", Toast.LENGTH_SHORT).show()
    }
}