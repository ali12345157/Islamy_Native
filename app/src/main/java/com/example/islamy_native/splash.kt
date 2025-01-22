package com.example.islamy_native

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.splash)
        Handler(Looper.getMainLooper())
            .postDelayed({
                navigateToHomeScreen()
            },2000)

    }
    private fun navigateToHomeScreen()
    {
        val intent=Intent(this,Home::class.java)
        startActivity(intent)
        finish()



    }
}