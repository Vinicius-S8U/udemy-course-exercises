package com.example.lucky_number

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lucky_number.databinding.ActivityLuckyNumberBinding
import kotlin.random.Random

class LuckyNumberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLuckyNumberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLuckyNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val luckyNumber = Random.nextInt(1000)
        updateLuckyNumberText(luckyNumber)

        val username = intent.extras?.getString("username").toString()
        setOnClick(username,luckyNumber)
        Log.i("TEST","" +luckyNumber)
        Log.i("TEST",username)
    }

    private fun updateLuckyNumberText(num: Int) {
        binding.luckyActvTvResult.text = num.toString()
    }

    private fun setOnClick(username: String, num: Int) {
        binding.luckyActvBtn.setOnClickListener {
            shareResultByGmail(username, num)
        }
    }

    private fun shareResultByGmail(username: String, num: Int) {
        var intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today")
        intent.putExtra(Intent.EXTRA_TEXT, "His lucky number is $num")
        startActivity(intent)
    }
}