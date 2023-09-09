package com.example.legalmate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.legalmate.databinding.ActivityNameBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase




class NameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNameBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.button.setOnClickListener {
            val name = binding.editTextText.text.toString()
            val contact = binding.editTextText2.text.toString()


            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(name, contact)
            database.child(name).setValue(User).addOnSuccessListener {
                binding.editTextText.text.clear()
                binding.editTextText2.text.clear()
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show()
            }


            val i = Intent(this, NameActivity2::class.java).also {
                startActivity(it)
            }
        }


    }
}



