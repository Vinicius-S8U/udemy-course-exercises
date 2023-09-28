package com.example.journal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.journal.databinding.ActivityJournalListBinding

class JournalList : AppCompatActivity() {
    private lateinit var binding: ActivityJournalListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal_list)
    }
}