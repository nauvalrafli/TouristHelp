package com.example.touristhelp

import android.graphics.Bitmap
import android.net.Uri

data class Hotel(
    val nama : String,
    val harga : String,
    val lokasi : String,
    val gambar : Uri?
)