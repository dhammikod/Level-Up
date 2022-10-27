package com.a706012110039.levelup

import Database.GlobalVar
import adaptor.RecyclerViewNewsAdaptor
import adaptor.recyclerviewRecentsAdaptor
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.a706012110039.levelup.databinding.FragmentHomeBinding
import com.denzcoskun.imageslider.models.SlideModel
import model.projects
import model.user
import com.denzcoskun.imageslider.constants.ScaleTypes
import model.news

class HomeFragment : Fragment() {
    private lateinit var viewbind: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewbind = FragmentHomeBinding.inflate(layoutInflater)
        adddummydatarecents()
        tesads()
        tesnews()

        return viewbind.root
    }

    fun tesnews(){
        var listnews : ArrayList<news>
        listnews = ArrayList()
        listnews.add(news("news1","dhamPT","uri"))
        listnews.add(news("news2","hagen.Co","uri"))
        listnews.add(news("news3","Ke-VIN-cent","uri"))

        val newsAdaptor: RecyclerViewNewsAdaptor
        newsAdaptor = RecyclerViewNewsAdaptor(listnews)
        viewbind.recyclerviewnews.layoutManager = LinearLayoutManager(requireActivity().baseContext, LinearLayoutManager.VERTICAL, false)
        viewbind.recyclerviewnews.adapter = newsAdaptor
    }

    fun tesads(){
        val imageList = ArrayList<SlideModel>() // Create image list

        imageList.add(SlideModel(R.drawable.news1, "news 1",ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.news2, "news 2",ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.news3, "news 3",ScaleTypes.FIT))

        viewbind.carouselnews.setImageList(imageList)
    }

    fun adddummydatarecents(){
        var curuser: user

        var iduser = 0
        if (GlobalVar.users.size > 0){
            iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
        }
        curuser = user(iduser,"dham","email","free",0,0,0, arrayListOf("teacher", "bla1"), arrayListOf(),
            arrayListOf())

        var idproject = 0

        for(i in 0..5){
            if (GlobalVar.users.size > 0){
                idproject = GlobalVar.users[GlobalVar.users.size-1].id + 1
            }
            GlobalVar.projects.add(projects(idproject,"title","cilukba","lorem50","penting","oktober", arrayListOf(),
                arrayListOf(), arrayListOf(), arrayListOf(),1,
                arrayListOf()))
        }
        curuser.mycurprojects.add(0)
        curuser.mycurprojects.add(1)

        //jangan hapus yang ini soalnya mau di pakai nanti
        //jangan hapus yang ini soalnya mau di pakai nanti
        //jangan hapus yang ini soalnya mau di pakai nanti
        //jangan hapus yang ini soalnya mau di pakai nanti
        if(curuser.mycurprojects.size < 3){
            curuser.mycurprojects.add(-1)
        }
        val recentsAdaptor: recyclerviewRecentsAdaptor
        recentsAdaptor = recyclerviewRecentsAdaptor(curuser.mycurprojects)
        viewbind.RVrecentprojects.layoutManager = LinearLayoutManager(requireActivity().baseContext, LinearLayoutManager.HORIZONTAL, false)
        viewbind.RVrecentprojects.adapter = recentsAdaptor
    }
}