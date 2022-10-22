package com.a706012110039.levelup

import adaptor.recyclerviewRecentsAdaptor
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.a706012110039.levelup.databinding.FragmentHomeBinding
import model.projects
import model.user

class HomeFragment : Fragment() {
    private lateinit var viewbind: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewbind = FragmentHomeBinding.inflate(layoutInflater)
        adddummydatarecents()
        viewbind.button.setOnClickListener(){

            val myIntent = Intent(context,ProjectActivity::class.java).apply{
//                putExtra("position",position)
            }
            startActivity(myIntent)
        }
        return viewbind.root
    }

    fun adddummydatarecents(){
        var curuser: user
        var projects: projects

        curuser = user("dham","email","free",0,0,0, arrayListOf("teacher", "bla1"), arrayListOf(),
            arrayListOf())
        projects = projects("title","cilukba","lorem50","penting","oktober", arrayListOf(),
            arrayListOf())
        curuser.mycurprojects.add(projects)


        //jangan hapus yang ini soalnya mau di pakai nanti
        //jangan hapus yang ini soalnya mau di pakai nanti
        //jangan hapus yang ini soalnya mau di pakai nanti
        //jangan hapus yang ini soalnya mau di pakai nanti
        if(curuser.mycurprojects.size < 3){
            curuser.mycurprojects.add(projects("","","", "","",arrayListOf(), arrayListOf()))
        }
        val recentsAdaptor: recyclerviewRecentsAdaptor
        recentsAdaptor = recyclerviewRecentsAdaptor(curuser.mycurprojects)
        viewbind.RVrecentprojects.layoutManager = LinearLayoutManager(requireActivity().baseContext, LinearLayoutManager.HORIZONTAL, false)
        viewbind.RVrecentprojects.adapter = recentsAdaptor
    }
}