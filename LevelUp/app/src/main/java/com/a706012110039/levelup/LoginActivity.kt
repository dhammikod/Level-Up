package com.a706012110039.levelup

import Database.GlobalVar
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
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
            if(selectprofessionfinished()){
                val Intent = Intent(this, BottomnavbarActiity::class.java)
                startActivity(Intent)
            }else{
                val Intent = Intent(this, Choose_profession_Activity::class.java)
                startActivity(Intent)
            }
            GlobalVar.curuser = 0
        }

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE),
            PackageManager.PERMISSION_GRANTED)
    }

    fun checkRemember() {
        shared = getSharedPreferences("shared", Context.MODE_PRIVATE)
        remember = shared.getBoolean("remember", false)

        if(remember){
//            val intent = Intent(this, MainActivity::class.java)
            val intent = Intent(this, BottomnavbarActiity::class.java)
            startActivity(intent)
        }

    }

    private fun selectprofessionfinished(): Boolean{
        val sharedPref = this.getSharedPreferences("selectprofession", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }
}