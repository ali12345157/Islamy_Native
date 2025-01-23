package com.example.islamy_native

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.islamy_native.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.bottomNav.setOnItemSelectedListener{menuItem ->
          if (  menuItem.itemId==R.id.quran)
              navigate(quran())
          else if (menuItem.itemId==R.id.hadeth)
              navigate(hadeth())
          else if (menuItem.itemId==R.id.tasbeeh)
              navigate(sebha())
            else
                navigate(radio())
            return@setOnItemSelectedListener true
        }
        binding.bottomNav.selectedItemId=R.id.quran

    }
    private fun navigate(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction().replace(R.id.fragment,fragment)
            .commit()


    }
}