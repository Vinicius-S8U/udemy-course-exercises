package com.example.top_games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.main_rv)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)

        var gamesList = arrayListOf(
            GameModel(R.drawable.birds,"Angry Birds"),
            GameModel(R.drawable.clash,"Clash of Clans"),
            GameModel(R.drawable.genshin,"Genshin Impact"),
            GameModel(R.drawable.plants,"Plants vs Zombies"),
            GameModel(R.drawable.subway,"Subway Surfers"),
            GameModel(R.drawable.jetpack,"Jetpack Joyride"),
        )
        val adapter = GameAdapter(gamesList)
        recyclerView.adapter = adapter
    }
}