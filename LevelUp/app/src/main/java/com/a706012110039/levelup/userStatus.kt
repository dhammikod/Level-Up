package com.a706012110039.levelup

import Database.GlobalVar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a706012110039.levelup.databinding.ActivityUserStatusBinding

class userStatus : AppCompatActivity() {
    private lateinit var viewbind: ActivityUserStatusBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbind = ActivityUserStatusBinding.inflate(layoutInflater)

        viewbind.freeUserCv.setOnClickListener {
            GlobalVar.users[GlobalVar.curuser].statuspremium = "free user"
            finish()
        }

        viewbind.premiumUserCv.setOnClickListener {
            GlobalVar.users[GlobalVar.curuser].statuspremium = "premium user"
            finish()
        }

        viewbind.onePassUserCv.setOnClickListener {
            GlobalVar.users[GlobalVar.curuser].statuspremium = "pass user"
            finish()
        }

        viewbind.imageView26.setOnClickListener {
            finish()
        }

        setContentView(viewbind.root)
    }
}