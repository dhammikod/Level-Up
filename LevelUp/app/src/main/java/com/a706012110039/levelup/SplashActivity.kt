package com.a706012110039.levelup

import Database.GlobalVar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a706012110039.levelup.databinding.ActivitySplashBinding
import model.user

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
            val myintent = Intent(this, LoginActivity::class.java)
            var iduser = 0
            if (GlobalVar.users.size > 0){
                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
            }
            GlobalVar.users.add(
                user(iduser,"quantum","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                arrayListOf(), arrayListOf())
            )
            startActivity(myintent)
            finish()
        }
    }
}