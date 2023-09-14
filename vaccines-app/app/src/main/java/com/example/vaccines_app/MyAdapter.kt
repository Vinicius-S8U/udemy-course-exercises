package com.example.vaccines_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val vaccinesList: ArrayList<VaccineModel>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var vaccineImage: ImageView
        var vaccineTitle: TextView

        init {
            vaccineImage = itemView.findViewById(R.id.main_actv_item_img)
            vaccineTitle = itemView.findViewById(R.id.main_actv_item_tv_title)
            itemView.setOnClickListener{
                Toast.makeText(itemView.context,
                    "You've chosen ${vaccinesList[adapterPosition].title}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return vaccinesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.vaccineTitle.setText(vaccinesList[position].title)
        holder.vaccineImage.setImageResource(vaccinesList[position].img)
    }
}