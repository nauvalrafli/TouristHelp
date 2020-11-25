package com.example.touristhelp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.touristhelp.R
import com.example.touristhelp.databinding.ActivityBiofillBinding

class BiofillActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBiofillBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_biofill)

    }
}