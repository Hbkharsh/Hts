package com.example.legalmate


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.legalmate.databinding.FragmentHomeBinding




class HomeFragment : Fragment(R.layout.fragment_home){
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentHomeBinding.inflate(inflater, container, false).also { it.also { _binding = it } }



         binding.imageView7.setOnClickListener {
             val i = Intent(this@HomeFragment.requireContext(), NameActivity::class.java).also{
                 startActivity(it)
             }
         }
        binding.imageView6.setOnClickListener {
            val j = Intent(this@HomeFragment.requireContext(), Drugs::class.java).also {
                 startActivity(it)
             }
        }
        return binding.root



    }
}







