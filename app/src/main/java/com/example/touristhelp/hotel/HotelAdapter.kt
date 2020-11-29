package com.example.touristhelp.hotel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.touristhelp.R

class HotelAdapter(private val list : ArrayList<Hotel>, val requester : Context) :RecyclerView.Adapter<HotelAdapter.MyHolder>() {

    private var onClicked : OnClicked? = null

    fun callableOnClick(onClicked: OnClicked){
        this.onClicked = onClicked
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_card,parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val hotels: Hotel = list[position]

        holder.nama.text = hotels.nama
        holder.harga.text = hotels.harga
        holder.lokasi.text = hotels.lokasi
        holder.gambar.setImageResource(hotels.gambar)

        holder.bind(hotels)
    }

    override fun getItemCount(): Int = 3

    inner class MyHolder (val view: View) : RecyclerView.ViewHolder(view) {
        val nama = itemView.findViewById<TextView>(R.id.tvNameCard)
        val harga = itemView.findViewById<TextView>(R.id.tvPriceCard)
        val lokasi = itemView.findViewById<TextView>(R.id.tvLocCard)
        val gambar = itemView.findViewById<ImageView>(R.id.ivPicCard)

        fun bind(point: Hotel) {
            itemView.setOnClickListener { onClicked?.onItemClicked(point) }
        }
    }

    interface OnClicked{
        fun onItemClicked(data : Hotel)
    }

}
