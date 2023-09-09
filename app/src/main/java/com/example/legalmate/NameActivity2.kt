package com.example.legalmate

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.example.legalmate.databinding.ActivityName2Binding
import com.google.firebase.storage.FirebaseStorage
import java.util.Date




class NameActivity2 : AppCompatActivity() {

    private  var _binding: ActivityName2Binding? = null
    private val binding: ActivityName2Binding
        get() = _binding!!


    private val storage = FirebaseStorage.getInstance()

    private val requestPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()){
        it?.let {

            if(it){
                this.makeToast("Permission Granted")
            }

        }
        }


    private val fileAccess = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                 it.data?.data?.let{
                     val inputStream = this.contentResolver.openInputStream(it)
                     inputStream?.readBytes()?.let {
                         uploadFile(it)
                     }
                 }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityName2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button5.setOnClickListener {
            sdkIntOverO(this){

                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
                intent.addCategory(Intent.CATEGORY_OPENABLE)
                intent.type = "*/*"


                fileAccess.launch(intent)
            }
        }


        binding.button2.setOnClickListener {
            val i = Intent(this,LocationActivity::class.java).also{
                startActivity(it)
            }

        }
    }


    fun uploadFile(byteArray: ByteArray){
        val storageRef = storage.reference

        storageRef.child("images/${Date().time}").putBytes(byteArray).addOnSuccessListener {
            this.makeToast("Sucess")
        }.addOnFailureListener{
            this.makeToast("Failed")
        }.addOnCompleteListener{
            this.makeToast("Completed")
        }
    }


    fun Context.makeToast(message: String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    fun sdkIntOverO(context: Context,call:()->Unit){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            if(ActivityCompat.checkSelfPermission(context,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE)
                ==PackageManager.PERMISSION_GRANTED)
            {
                call.invoke()
            }else{
                   requestPermission.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
    }
}