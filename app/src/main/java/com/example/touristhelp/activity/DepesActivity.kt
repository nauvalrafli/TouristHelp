package com.example.touristhelp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.touristhelp.R
import com.example.touristhelp.databinding.ActivityDepesBinding

class DepesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDepesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_depes)


    }

}