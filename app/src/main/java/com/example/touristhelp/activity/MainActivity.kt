package com.example.touristhelp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.touristhelp.Hotel
import com.example.touristhelp.R
import com.example.touristhelp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var ary : Array<Hotel>
    lateinit var linearLayoutManager : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager


    }

    fun initData() {
        val namaHotel = resources.getStringArray(R.array.hotelname)
        val hargaHotel = resources.getStringArray(R.array.hotelharga)
        val lokasiHotel = resources.getStringArray(R.array.hotellokasi)
        val imgRes = resources.obtainTypedArray(R.array.hotelImg)
    }
}