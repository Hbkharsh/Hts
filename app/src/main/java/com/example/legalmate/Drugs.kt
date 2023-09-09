package com.example.legalmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.legalmate.databinding.ActivityDrugsBinding


private lateinit var binding:ActivityDrugsBinding
class Drugs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrugsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnDrugs1.setOnClickListener {
            val i = Intent(this,DrugsThird::class.java).also{
                startActivity(it)}}

    }
}