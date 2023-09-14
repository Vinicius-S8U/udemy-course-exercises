package com.example.french_teacher

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.french_teacher.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun sayColorInFrench(view:View){
        val clickedButton = view as Button
        var mediaPlayer = MediaPlayer.create(
            this,
            resources.getIdentifier(clickedButton.tag.toString(), "raw", packageName)
        )
        mediaPlayer.start()
    }

}