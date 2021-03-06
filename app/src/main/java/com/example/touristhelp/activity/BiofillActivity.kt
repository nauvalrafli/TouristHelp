package com.example.touristhelp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.touristhelp.R
import com.example.touristhelp.databinding.ActivityBiofillBinding
import com.example.touristhelp.webApi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BiofillActivity : AppCompatActivity() {

    private lateinit var b: ActivityBiofillBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = DataBindingUtil.setContentView(this, R.layout.activity_biofill)
        val intent = intent

        b.tvNamaPesan.text = intent.getStringExtra("Nama")
        b.tvHargaPesan.text = intent.getStringExtra("Harga")
        b.etIdCar.text = intent.getIntExtra("id", 0).toString()

        b.btBayar2.setOnClickListener { goPay() }
    }

    fun goPay() {
        intent = Intent(this, DepesActivity::class.java)
        intent.putExtra("Nama", b.tvHargaPesan.text.toString())
        goPost()
    }

    fun goPost() {
        RetrofitClient.instance.postApi(
                b.etNama.text.toString(),
                b.etPassword.text.toString(),
                b.etGender.text.toString(),
                b.etEmail.text.toString(),
                b.etPhone.text.toString()   ,
                b.etLocation.text.toString(),
                b.etIdCar.text.toString()
        ).enqueue(object : Callback<postCar>{
            val intent = Intent(this@BiofillActivity, DepesActivity::class.java)

            override fun onResponse(call: Call<postCar>, response: Response<postCar>) {
                Toast.makeText(this@BiofillActivity, "Posted", Toast.LENGTH_LONG).show()
                intent.putExtra("Hasil", "Terimakasih telah melakukan transaksi")
                startActivity(intent)
            }

            override fun onFailure(call: Call<postCar>, t: Throwable) {
                Toast.makeText(this@BiofillActivity, "Transaction Success", Toast.LENGTH_LONG).show()
                intent.putExtra("Hasil", "Transaksi telah berhasil dilakukan")
                startActivity(intent)
            }

        })
    }
}