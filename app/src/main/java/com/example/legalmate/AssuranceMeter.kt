package com.example.legalmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.legalmate.databinding.ActivityAssuranceMeterBinding
import com.example.legalmate.databinding.ActivityName2Binding

private lateinit var binding: ActivityAssuranceMeterBinding
class AssuranceMeter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssuranceMeterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button4.setOnClickListener {
            val i = Intent(this,Done::class.java).also{
                startActivity(it)
            }
        }

    }
}