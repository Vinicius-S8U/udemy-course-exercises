package com.example.coroutines_app_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutines_app_2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        helloFromMainThread()
        helloFromIoThread()
    }

    private fun helloFromIoThread() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.tvMainThread.text = Thread.currentThread().name
        }
    }

    private fun helloFromMainThread() {
        CoroutineScope(Dispatchers.IO).launch {
            binding.tvSecondaryThread.text = Thread.currentThread().name
        }
    }
}