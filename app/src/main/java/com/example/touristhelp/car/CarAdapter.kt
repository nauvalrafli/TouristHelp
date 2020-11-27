package com.example.touristhelp.car

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.touristhelp.Hotel
import com.example.touristhelp.HotelAdapter
import com.example.touristhelp.R
import java.net.URL

class CarAdapter(val list: ArrayList<Car>) : RecyclerView.Adapter<CarAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_card,parent,false))
    }

    override fun onBindViewHolder(holder: CarAdapter.MyHolder, position: Int) {
        val Cars: Car = list.get(position)

        holder.nama.text = Cars.car_name
        holder.harga.text = Cars.hire_cost.toString()
        holder.lokasi.text = Cars.status

        var url = URL(Cars.image)
        var bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())

        holder.gambar.setImageBitmap(bmp)
    }

    override fun getItemCount(): Int = list.size

    inner class MyHolder (val view: View) : RecyclerView.ViewHolder(view) {
        val nama = itemView.findViewById<TextView>(R.id.tvNameCard)
        val harga = itemView.findViewById<TextView>(R.id.tvPriceCard)
        val lokasi = itemView.findViewById<TextView>(R.id.tvLocCard)
        val gambar = itemView.findViewById<ImageView>(R.id.ivPicCard)
    }
}
