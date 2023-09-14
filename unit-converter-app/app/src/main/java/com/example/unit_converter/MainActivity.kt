package com.example.unit_converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.unit_converter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setOnClick()
    }

    private fun setOnClick(){
        binding.actvMainBtn.setOnClickListener{
            binding.actvMainTvWeight.text = makeConversion(binding.actvMainEtInput.text.toString().toDouble()).toString()
        }
    }


    private fun makeConversion(kilos:Double): Double{
        return kilos * 2.20462
    }
}