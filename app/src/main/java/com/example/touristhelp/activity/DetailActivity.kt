package com.example.touristhelp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.touristhelp.R
import com.example.touristhelp.hotel.*
import com.example.touristhelp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding
    companion object{
        var man = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val intent = intent

        man = intent.getIntExtra("id", 0)
        binding.tvNamaDetail.text = intent.getStringExtra("nama")
        binding.tvHargaDetail.text = intent.getStringExtra("harga")
        binding.tvLokasi.text = intent.getStringExtra("desc")
        Glide.with(this).load(intent.getStringExtra("gambar")).into(binding.ivDetail)

        binding.btBayar.setOnClickListener { goProceed() }
    }

    fun goProceed() {
        intent = Intent(this, BiofillActivity::class.java)
        val ngintent = intent
        intent.putExtra("Nama", binding.tvNamaDetail.text.toString())
        intent.putExtra("Harga", binding.tvHargaDetail.text.toString())
        intent.putExtra("id", man)
        startActivity(intent)
    }
}