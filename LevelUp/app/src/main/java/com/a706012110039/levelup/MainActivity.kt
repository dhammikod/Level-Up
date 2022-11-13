package com.a706012110039.levelup

import Database.GlobalVar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a706012110039.levelup.databinding.ActivityMainBinding
import model.user

class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.Signup.setOnClickListener {
            var iduser = 0
            if (GlobalVar.users.size > 0){
                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
            }
            GlobalVar.users.add(user(iduser,"quantum","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                arrayListOf(), arrayListOf()))
            finish()
        }

        binding.Login.setOnClickListener {
            finish()
        }
    }
}