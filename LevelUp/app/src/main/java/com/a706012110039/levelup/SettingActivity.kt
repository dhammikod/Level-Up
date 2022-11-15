package com.a706012110039.levelup

import Database.GlobalVar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a706012110039.levelup.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var viewbind: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewbind = ActivitySettingBinding.inflate(layoutInflater)

        setupdata()

        setContentView(viewbind.root)
    }

    fun setupdata(){
        viewbind.usernameTextinputlayout.editText?.setText(GlobalVar.users[GlobalVar.curuser].name)
        viewbind.emailTextinputlayout.editText?.setText(GlobalVar.users[GlobalVar.curuser].Email )
        viewbind.passwordTextinputlayout.editText?.setText(GlobalVar.users[GlobalVar.curuser].password)

    }
}