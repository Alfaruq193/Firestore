package com.varoo.firestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.varoo.firestore.databinding.ActivityDetailProdukBinding


class DetailProdukActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailProdukBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProdukBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


    }
}