package com.a706012110039.levelup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a706012110039.levelup.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.Signup.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        binding.textView4.setOnClickListener {
            val Intent = Intent(this, ForgotPassword::class.java)
            startActivity(Intent)
        }

        binding.Login.setOnClickListener {
            val Intent = Intent(this, BottomnavbarActiity::class.java)
            startActivity(Intent)
        }
    }
}