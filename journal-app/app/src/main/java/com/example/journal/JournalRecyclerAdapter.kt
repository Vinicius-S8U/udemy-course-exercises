package com.example.journal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.journal.databinding.JournalRowBinding

class JournalRecyclerAdapter(var journalList: List<Journal>) :
    RecyclerView.Adapter<JournalRecyclerAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = JournalRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return journalList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }


    inner class MyViewHolder(private val binding: JournalRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() = with(binding) {
            val journal: Journal = journalList[adapterPosition]
            journalRowDescription.text = journal.thoughts
            journalRowUsername.text = journal.title
            journalRowDateCreated.text = "Posted at: ${journal.timeAdded}"
        }
    }
}