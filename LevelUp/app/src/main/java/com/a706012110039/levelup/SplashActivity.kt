package com.a706012110039.levelup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a706012110039.levelup.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.imageView.alpha = 0f


        binding.imageView.animate().setDuration(3000).alpha(1f).withEndAction{
//            val myintent = Intent(this, MainActivity::class.java)
            val myintent = Intent(this, MainActivity::class.java)
            startActivity(myintent)
            finish()
        }
    }
}