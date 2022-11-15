package com.a706012110039.levelup

import Database.GlobalVar
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.a706012110039.levelup.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var viewbind: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setupdata()

        viewbind.status.setOnClickListener {
            val Intent = Intent(activity, userStatus::class.java)
            startActivity(Intent)
        }

        viewbind.imageView5.setOnClickListener {
            val Intent = Intent(activity, SettingActivity::class.java)
            startActivity(Intent)
        }
        return viewbind.root
    }

    fun setupdata(){
        viewbind = FragmentProfileBinding.inflate(layoutInflater)
        viewbind.name.text = GlobalVar.users[GlobalVar.curuser].name
        viewbind.email.text = GlobalVar.users[GlobalVar.curuser].Email
        viewbind.status.text = GlobalVar.users[GlobalVar.curuser].statuspremium

        //recyclerview profession
        viewbind.profession1.text = GlobalVar.users[GlobalVar.curuser].profession[0]
        viewbind.profession2.text = GlobalVar.users[GlobalVar.curuser].profession[1]
        viewbind.profession3.text = GlobalVar.users[GlobalVar.curuser].profession[2]

        viewbind.textView18.text = GlobalVar.users[GlobalVar.curuser].projectdone.toString()
        viewbind.textView20.text = GlobalVar.users[GlobalVar.curuser].filesuploaded.toString()
        viewbind.textView22.text = GlobalVar.users[GlobalVar.curuser].comments.toString()
    }
}