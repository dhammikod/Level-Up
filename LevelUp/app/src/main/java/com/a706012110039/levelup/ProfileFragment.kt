package com.a706012110039.levelup

import Database.GlobalVar
import adaptor.RecyclerViewProfessionAdapter
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.a706012110039.levelup.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.activity_bottomnavbar_actiity.*

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

        val professionadaptor: RecyclerViewProfessionAdapter
        professionadaptor = RecyclerViewProfessionAdapter(GlobalVar.users[GlobalVar.curuser].profession)
        viewbind.rvProfession.layoutManager = LinearLayoutManager(requireActivity().baseContext, LinearLayoutManager.HORIZONTAL, false)
        viewbind.rvProfession.adapter = professionadaptor

        viewbind.textView18.text = GlobalVar.users[GlobalVar.curuser].projectdone.toString()
        viewbind.textView20.text = GlobalVar.users[GlobalVar.curuser].filesuploaded.toString()
        viewbind.textView22.text = GlobalVar.users[GlobalVar.curuser].comments.toString()
    }

    override fun onResume() {
        super.onResume()
        viewbind.status.text = GlobalVar.users[GlobalVar.curuser].statuspremium
        viewbind.name.text = GlobalVar.users[GlobalVar.curuser].name
        viewbind.email.text = GlobalVar.users[GlobalVar.curuser].Email
    }
}