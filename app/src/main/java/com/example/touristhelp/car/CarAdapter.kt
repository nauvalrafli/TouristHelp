package com.example.touristhelp.car

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.touristhelp.R
import java.io.InputStream
import java.net.URL


class CarAdapter(val list: ArrayList<Car>, act : Activity) : RecyclerView.Adapter<CarAdapter.MyHolder>() {

    private var onClicked : OnCarClicked? = null
    var act = act

    fun callableCarOnClick(onCarClicked: OnCarClicked){
        this.onClicked = onCarClicked
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.custom_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CarAdapter.MyHolder, position: Int) {
        val cars: Car = list.get(position)

        holder.nama.text = cars.car_name
        holder.harga.text = cars.hire_cost.toString()
        holder.lokasi.text = cars.status

        holder.bind(cars)

        try {
            Glide.with(act).load(cars.image).into(holder.gambar)
        } catch (e: Exception) {
            Log.d("man", "Still can't be loaded")
        }

    }

    override fun getItemCount(): Int = list.size

    inner class MyHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nama = itemView.findViewById<TextView>(R.id.tvNameCard)
        val harga = itemView.findViewById<TextView>(R.id.tvPriceCard)
        val lokasi = itemView.findViewById<TextView>(R.id.tvLocCard)
        val gambar = itemView.findViewById<ImageView>(R.id.ivPicCard)

        fun bind(point: Car) {
            itemView.setOnClickListener { onClicked?.onCarClicked(point) }
        }
    }

    interface OnCarClicked{
        fun onCarClicked(data: Car)
    }
}
