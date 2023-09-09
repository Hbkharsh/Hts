package com.example.legalmate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import com.example.legalmate.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val firstFragment = HomeFragment()
        val secondFragment = ExploreFragment()


        setCurrentFragment(firstFragment)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId)  {
                R.id.home -> setCurrentFragment(firstFragment)
                R.id.explore -> setCurrentFragment(secondFragment)

            }
            true
        }
        }

  private fun setCurrentFragment(fragment: Fragment) =
      supportFragmentManager.beginTransaction().apply {
          replace(R.id.flfragment,fragment)
          commit()
      }

}
