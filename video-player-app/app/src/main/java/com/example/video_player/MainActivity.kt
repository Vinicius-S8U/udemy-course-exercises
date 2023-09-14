package com.example.video_player

import android.media.AudioAttributes
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.video_player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoView = binding.mainActvVdMain
        val secondaryVideoView = binding.mainActvVdSecondary

        videoView.setVideoPath("android.resource://" + packageName + "/" + R.raw.yvette)
        secondaryVideoView.setVideoPath("android.resource://" + packageName + "/" + R.raw.song)

        val mediaController = MediaController(this)

        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)
        videoView.setOnPreparedListener{
            it.setVolume(0f,0f)
            it.isLooping = true
        }
        videoView.start()

        secondaryVideoView.setMediaController(mediaController)
        secondaryVideoView.start()
    }
}