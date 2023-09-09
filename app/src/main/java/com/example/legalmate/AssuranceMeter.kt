package com.example.legalmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.legalmate.databinding.ActivityAssuranceMeterBinding

private lateinit var binding: ActivityAssuranceMeterBinding
class AssuranceMeter : AppCompatActivity() {
    var startPoint = 0
    var endPoint = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssuranceMeterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
         binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
             override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
               binding.textView10.text = android.R.id.progress.toString()
             }

             override fun onStartTrackingTouch(p0: SeekBar?) {
                if(binding.seekBar!= null){
                    startPoint = binding.seekBar.progress
                }
             }

             override fun onStopTrackingTouch(p0: SeekBar?) {
                 if(binding.seekBar!= null ){
                     endPoint = binding.seekBar.progress
                 }
             }

         })

        binding.button4.setOnClickListener {
            val i = Intent(this,Done::class.java).also{
                startActivity(it)


            }
        }

    }
}