package com.example.top_games

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(val gamesList: ArrayList<GameModel>) :
    RecyclerView.Adapter<GameAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var gameImg: ImageView = itemView.findViewById(R.id.main_item_img)
        var gameTitle: TextView = itemView.findViewById(R.id.main_item_tv)
        init {
            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    "You've chosen ${gamesList[adapterPosition].txtCard}",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.gameImg.setImageResource(gamesList[position].imgCard)
        holder.gameTitle.text = gamesList[position].txtCard
    }


}