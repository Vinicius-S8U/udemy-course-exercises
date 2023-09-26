package com.example.coroutines_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutines_app.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var counter  = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCounter.setOnClickListener{
            binding.tvCounter.text = (++counter).toString()
        }

        binding.btnMainThread.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch {
                simulateDownload()
            }
        }

        binding.btnCoroutinesThread.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                    simulateDownload()
            }
        }
    }

    private suspend fun simulateDownload() {
        for(i in 1 ..100000){
            Log.i("Counter","Downloading ${(i * 100) / 100000.toDouble() }% in ${Thread.currentThread().name}")
            withContext(Dispatchers.Main) {
                binding.tvDownloadPercentage.text = "${(i * 100) / 100000.toDouble() }% in ${Thread.currentThread().name}"
            }
        }
    }
}