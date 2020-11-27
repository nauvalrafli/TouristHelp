package com.example.touristhelp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

class HotelAdapter(private val list : ArrayList<Hotel>) :RecyclerView.Adapter<HotelAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_card,parent,false))
    }

    override fun onBindViewHolder(holder: HotelAdapter.MyHolder, position: Int) {
        val hotels: Hotel = list.get(position)

        holder.nama.text = hotels.nama
        holder.harga.text = hotels.harga
        holder.lokasi.text = hotels.lokasi
        holder.gambar.setImageURI(hotels.gambar)
    }

    override fun getItemCount(): Int = 3

    inner class MyHolder (val view: View) : RecyclerView.ViewHolder(view) {
        val nama = itemView.findViewById<TextView>(R.id.tvNameCard)
        val harga = itemView.findViewById<TextView>(R.id.tvPriceCard)
        val lokasi = itemView.findViewById<TextView>(R.id.tvLocCard)
        val gambar = itemView.findViewById<ImageView>(R.id.ivPicCard)
    }

}
