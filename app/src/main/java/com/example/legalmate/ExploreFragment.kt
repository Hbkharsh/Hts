package com.example.legalmate

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.legalmate.databinding.FragmentExploreBinding


class ExploreFragment : Fragment(R.layout.fragment_explore) {
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.imageView5.setOnClickListener {
            val i = Intent(
                this@ExploreFragment.requireContext(),
                LeaderBoardActivity::class.java
            ).also {
                startActivity(it)
            }
        }

            binding.imageView8.setOnClickListener {
                val i = Intent(
                    this@ExploreFragment.requireContext(),
                    LeaderBoardActivity::class.java
                ).also {
                    startActivity(it)
                }
            }
            return binding.root
        }
    }

