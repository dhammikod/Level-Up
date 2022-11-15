package com.a706012110039.levelup

import Database.GlobalVar
import adaptor.RecyclerViewNewsAdaptor
import adaptor.recyclerviewRecentsAdaptor
import adaptor.recyclerviewUpcomingTaskAdaptor
import android.content.Intent
import android.os.Bundle
import android.util.Log
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
        upcomingtask()
        tesads()
        tesnews()


        return viewbind.root
    }

    fun tesnews(){
        var listnews : ArrayList<news>
        listnews = ArrayList()
        listnews.add(news("Plastico Corp, a recyling project turned business","BBC News","news_pic_1"))
        listnews.add(news("Animator, Combining puppets and animaton bringing back nostalgia","Shaun Whitore","news_pic_2"))
        listnews.add(news("Foodste, Leftover food as potential to start a business","BBC News","news_pic_3"))

        val newsAdaptor: RecyclerViewNewsAdaptor
        newsAdaptor = RecyclerViewNewsAdaptor(listnews)
        viewbind.recyclerviewnews.layoutManager = LinearLayoutManager(requireActivity().baseContext, LinearLayoutManager.VERTICAL, false)
        viewbind.recyclerviewnews.adapter = newsAdaptor
    }

    fun tesads(){
        val imageList = ArrayList<SlideModel>() // Create image list

        imageList.add(SlideModel(R.drawable.news1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.news2,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.news3, ScaleTypes.FIT))

        viewbind.carouselnews.setImageList(imageList)
    }

    fun upcomingtask() {
        var temp: ArrayList<String>
        temp = ArrayList()
        var tempINT = 0
        for (i in GlobalVar.projects) {
            var temppppp = 0
            for (x in GlobalVar.projects[tempINT].tasks) {
                if (GlobalVar.projects[tempINT].tasks[temppppp].status == "N") {
                    temp.add(GlobalVar.projects[tempINT].tasks[temppppp].title)
                }
                temppppp++

            }
            tempINT++
        }

        Log.d("here",temp.toString())

            val upcomingAdaptor: recyclerviewUpcomingTaskAdaptor
            upcomingAdaptor = recyclerviewUpcomingTaskAdaptor(temp)
            viewbind.UpcomingtaskRV.layoutManager =
                LinearLayoutManager(requireActivity().baseContext,
                    LinearLayoutManager.VERTICAL,
                    false)
            viewbind.UpcomingtaskRV.adapter = upcomingAdaptor

    }

    fun adddummydatarecents(){

        var idproject = 0

        if  (GlobalVar.projects.size<1){
        for(i in 0..5){
            if (GlobalVar.users.size > 0){
                idproject = GlobalVar.users[GlobalVar.users.size-1].id + 1
            }
            GlobalVar.projects.add(projects(idproject,"title","cilukba","lorem50","penting","oktober", arrayListOf(),
                arrayListOf(), arrayListOf(), arrayListOf(),1,
                arrayListOf()))
        }
            GlobalVar.users[GlobalVar.curuser].mycurprojects.add(0)

        }
        //jangan hapus yang ini soalnya mau di pakai nanti
        //jangan hapus yang ini soalnya mau di pakai nanti
        //jangan hapus yang ini soalnya mau di pakai nanti
        //jangan hapus yang ini soalnya mau di pakai nanti
        if(GlobalVar.users[GlobalVar.curuser].mycurprojects.size < 3 && !GlobalVar.users[GlobalVar.curuser].mycurprojects.contains(-1)){
            GlobalVar.users[GlobalVar.curuser].mycurprojects.add(-1)
        }else if(GlobalVar.users[GlobalVar.curuser].mycurprojects.size > 3 && GlobalVar.users[GlobalVar.curuser].mycurprojects.contains(-1)){
            GlobalVar.users[GlobalVar.curuser].mycurprojects.remove(-1)
        }

        val recentsAdaptor: recyclerviewRecentsAdaptor
        recentsAdaptor = recyclerviewRecentsAdaptor(GlobalVar.users[GlobalVar.curuser].mycurprojects)
        viewbind.RVrecentprojects.layoutManager = LinearLayoutManager(requireActivity().baseContext, LinearLayoutManager.HORIZONTAL, false)
        viewbind.RVrecentprojects.adapter = recentsAdaptor
    }
}