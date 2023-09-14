package com.example.word_cup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView = findViewById<ListView>(R.id.main_actv_lv)

        fun generateData(): ArrayList<CountryModel> {
            return arrayListOf(
                CountryModel("Brazil", "5", R.drawable.br_flag),
                CountryModel("Germany", "4", R.drawable.gm_flag),
                CountryModel("France", "2", R.drawable.fr_flag),
                CountryModel("Spain", "1", R.drawable.sp_flag),
                CountryModel("United Kingdom", "0", R.drawable.uk_flag),
                CountryModel("United States of America", "0", R.drawable.us_flag),
                CountryModel("Saudi Arabia", "0", R.drawable.sa_flag)
            )
        }

        var adapter = MyAdapter(this,generateData())
        listView?.adapter = adapter
        adapter?.notifyDataSetChanged()
    }
}