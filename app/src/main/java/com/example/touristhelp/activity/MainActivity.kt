package com.example.touristhelp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.touristhelp.*
import com.example.touristhelp.R
import com.example.touristhelp.databinding.ActivityMainBinding
import com.example.touristhelp.hotel.*
import com.example.touristhelp.car.*
import com.example.touristhelp.webApi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var adapter : HotelAdapter
    lateinit var adapter2 : CarAdapter
    lateinit var binding : ActivityMainBinding

    lateinit var list :ArrayList<Hotel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        list = ArrayList<Hotel>()
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
                Toast.makeText(this@MainActivity, "Unable to Load, check your connection", Toast.LENGTH_LONG).show()
            }

        })
    }

    fun getDataHotel(list: ArrayList<Hotel>) {
        val namaHotel = resources.getStringArray(R.array.hotelname)
        val hargaHotel = resources.getStringArray(R.array.hotelharga)
        val lokasiHotel = resources.getStringArray(R.array.hotellokasi)
        val gambarHotel = resources.obtainTypedArray(R.array.hotelImg)

        for(i in namaHotel.indices) {
            list.add(Hotel(namaHotel[i], hargaHotel[i], lokasiHotel[i], gambarHotel.getResourceId(i, 0)))
        }
    }

    fun bindHotelAdapter(list : ArrayList<Hotel>) {
        adapter = HotelAdapter(list, this@MainActivity)
        binding.rvHotel.setHasFixedSize(true)
        adapter.notifyDataSetChanged()
        binding.rvHotel.adapter = adapter

        adapter.callableOnClick(object : HotelAdapter.OnClicked{
            override fun onItemClicked(data: Hotel) {
                clicked(data.nama, data.harga, data.lokasi, data.nama.indexOf(data.nama))
            }
        })
    }

    fun bindCarAdapter(list: ArrayList<Car>) {
        adapter2 = CarAdapter(list, this@MainActivity)
        binding.rvCar.setHasFixedSize(true)
        adapter2.notifyDataSetChanged()
        binding.rvCar.adapter = adapter2

        adapter2.callableCarOnClick(object : CarAdapter.OnCarClicked{
            override fun onCarClicked(data: Car) {
                carClicked(data.car_name, data.hire_cost.toString(), data.status, data.car_id, data.image)
            }
        })
    }

    fun clicked(itemNama:String, itemHarga : String, itemDesc:String, car_id : Int = 0) {
        val intent = Intent(this, DetailActivity::class.java)
        val gambarHotel = resources.obtainTypedArray(R.array.hotelImg)
        intent.putExtra("nama", itemNama)
        intent.putExtra("harga", itemHarga)
        intent.putExtra("desc", itemDesc)
        intent.putExtra("id", car_id)
        intent.putExtra("gambar", gambarHotel.getResourceId(car_id, 0))
        startActivity(intent)
    }

    fun carClicked(itemNama:String, itemHarga : String, itemDesc:String, car_id : Int = 0, gambar : String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("nama", itemNama)
        intent.putExtra("harga", itemHarga)
        intent.putExtra("desc", itemDesc)
        intent.putExtra("id", car_id)
        intent.putExtra("gambar", gambar)
        startActivity(intent)
    }

}