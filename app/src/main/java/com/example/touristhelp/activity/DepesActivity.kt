package com.example.touristhelp.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.touristhelp.R
import com.example.touristhelp.databinding.ActivityDepesBinding

class DepesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDepesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_depes)
        val intent = Intent()
        binding.tvHasil.text = intent.getStringExtra("Hasil")

        goWeb()

        binding.btHasil.setOnClickListener { goMain() }
    }

    fun goMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun goWeb() {
        val goWeb = Intent(Intent.ACTION_VIEW, Uri.parse("http://12eb83e08361.ngrok.io/car_rental/pesan.php"))
        startActivity(goWeb)
    }
}