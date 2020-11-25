package com.example.touristhelp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.touristhelp.R
import com.example.touristhelp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        binding.btBayar.setOnClickListener { goProceed() }
    }

    fun goProceed() {
        intent = Intent(this, BiofillActivity::class.java)
        intent.putExtra("Nama", binding.tvNamaDetail.text.toString())
        intent.putExtra("Harga", binding.tvHargaDetail.text.toString())
        startActivity(intent)
    }
}