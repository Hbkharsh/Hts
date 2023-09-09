package com.example.legalmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.legalmate.databinding.ActivityDoneBinding
import com.example.legalmate.databinding.ActivityDrugsThirdBinding

private lateinit var binding: ActivityDoneBinding
class Done : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoneBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.imageView.animate().apply{
            duration = 1500
            rotationBy(360f)
        }.start()


        binding.buttonhome.setOnClickListener {
            val i = Intent(this,MainActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}