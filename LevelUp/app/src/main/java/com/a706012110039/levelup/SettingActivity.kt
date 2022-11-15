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

        viewbind.savechanges.setOnClickListener {
            checker()
        }

        setContentView(viewbind.root)
    }

    fun setupdata(){
        viewbind.usernameTextinputlayout.editText?.setText(GlobalVar.users[GlobalVar.curuser].name)
        viewbind.emailTextinputlayout.editText?.setText(GlobalVar.users[GlobalVar.curuser].Email )
        viewbind.passwordTextinputlayout.editText?.setText(GlobalVar.users[GlobalVar.curuser].password)
    }

    fun checker(){
        var correct = true
        if(viewbind.passwordTextinputlayout.editText?.text.toString().trim().isEmpty()){
            correct = false
            viewbind.passwordTextinputlayout.error = "Please fill put Password column"
        }
        if(viewbind.usernameTextinputlayout.editText?.text.toString().trim().isEmpty()){
            correct = false
            viewbind.usernameTextinputlayout.error = "Please fill put username column"
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(viewbind.emailTextinputlayout.editText?.text.toString().trim()).matches()){
            correct = false
            viewbind.emailTextinputlayout.error = "Please fill put correct email"
        }else if(viewbind.emailTextinputlayout.editText?.text.toString().trim().isEmpty()){
            viewbind.emailTextinputlayout.error = "Please fill put email column"
        }

        if(correct){
            GlobalVar.users[GlobalVar.curuser].Email = viewbind.emailTextinputlayout.editText?.text.toString().trim()
            GlobalVar.users[GlobalVar.curuser].password = viewbind.passwordTextinputlayout.editText?.text.toString().trim()
            GlobalVar.users[GlobalVar.curuser].name = viewbind.usernameTextinputlayout.editText?.text.toString().trim()
            finish()
        }
    }
}