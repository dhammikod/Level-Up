package com.a706012110039.levelup

import Database.GlobalVar
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a706012110039.levelup.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var shared: SharedPreferences
    var remember = false
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
            GlobalVar.curuser = 0
            startActivity(Intent)
        }
    }

    fun checkRemember() {
        shared = getSharedPreferences("shared", Context.MODE_PRIVATE)
        remember = shared.getBoolean("remember", false)

        if(remember){
//            val intent = Intent(this, MainActivity::class.java)
            val intent = Intent(this, BottomnavbarActiity::class.java)
            startActivity(intent)
            finish()
        }

    }
}