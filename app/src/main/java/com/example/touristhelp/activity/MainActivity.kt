package com.example.touristhelp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import com.example.touristhelp.Hotel
import com.example.touristhelp.R
import com.example.touristhelp.databinding.ActivityMainBinding
import com.example.touristhelp.HotelAdapter
import com.example.touristhelp.car.*
import com.example.touristhelp.webApi.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var ary : Array<Hotel>
    lateinit var adapter : HotelAdapter
    lateinit var adapter2 : CarAdapter
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val list = ArrayList<Hotel>()
        val carList = ArrayList<Car>()

        getDataHotel(list)
        bindHotelAdapter(list)

        goGet(carList)
        bindCarAdapter(carList)

    }

    fun goGet(carList : ArrayList<Car>) {
        RetrofitClient.instance.getApi().enqueue(object: Callback<ArrayList<Car>>{
            override fun onResponse(
                    call: Call<ArrayList<Car>>,
                    response: Response<ArrayList<Car>>
            ) {
                response.body()?.let { carList.addAll(it) }
                bindCarAdapter(carList)
            }

            override fun onFailure(call: Call<ArrayList<Car>>, t: Throwable) {

            }

        })
    }

    fun getDataHotel(list: ArrayList<Hotel>) {
        val namaHotel = resources.getStringArray(R.array.hotelname)
        val hargaHotel = resources.getStringArray(R.array.hotelharga)
        val lokasiHotel = resources.getStringArray(R.array.hotellokasi)
        val gambarHotel = resources.getStringArray(R.array.hotelImg)

        for(i in namaHotel.indices) {
            list.add(Hotel(namaHotel[i], hargaHotel[i], lokasiHotel[i], gambarHotel[i].toUri()))
        }
    }

    fun bindHotelAdapter(list : ArrayList<Hotel>) {
        adapter = HotelAdapter(list)
        binding.rvHotel.setHasFixedSize(true)
        adapter.notifyDataSetChanged()
        binding.rvHotel.adapter = adapter
    }

    fun bindCarAdapter(list: ArrayList<Car>) {
        adapter2 = CarAdapter(list)
        binding.rvCar.setHasFixedSize(true)
        adapter2.notifyDataSetChanged()
        binding.rvCar.adapter = adapter2
    }

    fun clicked(itemNama:String, itemHarga : String, itemDesc:String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("nama", itemNama)
        intent.putExtra("harga", itemHarga)
        intent.putExtra("desc", itemDesc)
        startActivity(intent)
    }

}