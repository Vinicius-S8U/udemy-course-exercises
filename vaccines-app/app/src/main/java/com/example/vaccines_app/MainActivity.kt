package com.example.vaccines_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.main_actv_rv)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        val data = arrayListOf(
            VaccineModel("Covid-19", R.drawable.vaccine_49359),
            VaccineModel("Hepatitis B", R.drawable.vaccine_49362),
            VaccineModel("Tatanus", R.drawable.vaccine_49366),
            VaccineModel("Pneumocal", R.drawable.vaccine_49371),
            VaccineModel("Rotavirus", R.drawable.vaccine_49359),
            VaccineModel("Measles", R.drawable.vaccine_49372),
            VaccineModel("Chickenpox", R.drawable.vaccine_49373)
        )

        val adapter = MyAdapter(data)
        recyclerView.adapter = adapter
    }
}