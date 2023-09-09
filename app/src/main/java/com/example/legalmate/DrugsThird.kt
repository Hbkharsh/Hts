package com.example.legalmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.legalmate.databinding.ActivityDrugsThirdBinding

private lateinit var binding: ActivityDrugsThirdBinding
class DrugsThird : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrugsThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonSubmit.setOnClickListener {
            val i = Intent(this,Done::class.java).also{
                startActivity(it)
            }
        }
    }
}