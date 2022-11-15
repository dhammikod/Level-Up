package com.a706012110039.levelup

import Database.GlobalVar
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.a706012110039.levelup.databinding.FragmentSplashBinding
import model.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class SplashFragment : Fragment() {
    private lateinit var viewbind: FragmentSplashBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewbind = FragmentSplashBinding.inflate(layoutInflater)

        viewbind.imageView.alpha = 0f


        viewbind.imageView.animate().setDuration(3000).alpha(1f).withEndAction{
//            var iduser = 0
//            if (GlobalVar.users.size > 0){
//                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
//            }
//            GlobalVar.users.add(
//                user(iduser,"quantum","password","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
//                    arrayListOf(), arrayListOf())
//            )
//
//            if (GlobalVar.users.size > 0){
//                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
//            }
//            GlobalVar.users.add(
//                user(1,"1","password","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
//                    arrayListOf(), arrayListOf())
//            )
//
//            if (GlobalVar.users.size > 0){
//                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
//            }
//            GlobalVar.users.add(
//                user(2,"2","password","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
//                    arrayListOf(), arrayListOf())
//            )
//
//            if (GlobalVar.users.size > 0){
//                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
//            }
//            GlobalVar.users.add(
//                user(3,"3","password","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
//                    arrayListOf(), arrayListOf())
//            )
//
//            if (GlobalVar.users.size > 0){
//                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
//            }
//            GlobalVar.users.add(
//                user(4,"4","password","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
//                    arrayListOf(), arrayListOf())
//            )
//
//            if (GlobalVar.users.size > 0){
//                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
//            }
//            GlobalVar.users.add(
//                user(5,"5","password","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
//                    arrayListOf(), arrayListOf())
//            )

            if(onboardingfinished()){
                findNavController().navigate(R.id.action_splashFragment_to_loginActivity)
                getActivity()?.finish()
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        }



        dummydata()
        // Inflate the layout for this fragment
        return viewbind.root
    }

    private fun onboardingfinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun dummydata(){

        val neededprofessionArray = ArrayList<String>()
        val discussionArray = ArrayList<discussion>()
        val tasksArray = ArrayList<task>()
        val enrolleduserArray = ArrayList<Int>()
        val filesArray = ArrayList<files>()

        GlobalVar.projects.add(projects(11,"Creative Design", "creative_des","","","",
            neededprofessionArray,discussionArray,tasksArray,enrolleduserArray,2, filesArray))

        GlobalVar.projects.add(projects(2,"Music Ally", "job_default","","","",
            neededprofessionArray,discussionArray,tasksArray,enrolleduserArray,3, filesArray))

        val roles1=ArrayList<String>()
        roles1.add("Programmer")
        roles1.add("Programmer")
        roles1.add("Programmer")


        val roles2=ArrayList<String>()
        roles2.add("UI/UX Designer")
        roles2.add("UI/UX Designer")
        roles2.add("UI/UX Designer")

        val roles3=ArrayList<String>()
        roles3.add("Marketing Director")
        roles3.add("UI/UX Designer")
        roles3.add("UI/UX Designer")

        val roles4=ArrayList<String>()
        roles4.add("Finance Officer")
        roles4.add("UI/UX Designer")
        roles4.add("UI/UX Designer")

        val roles5=ArrayList<String>()
        roles5.add("Operational Coordinator")
        roles5.add("UI/UX Designer")
        roles5.add("UI/UX Designer")



        val projectss=ArrayList<Int>()
        projectss.add(0)
        projectss.add(1)

        var iduser = 0
        if (GlobalVar.users.size > 0){
            iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
        }
        GlobalVar.users.add(user(iduser,"Vincent","password","vincent@email.com","Premium",0,0,0,roles1,projectss,projectss))

        if (GlobalVar.users.size > 0){
            iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
        }
        GlobalVar.users.add(user(iduser,"Dhammiko","password","vincent@email.com","Premium",0,0,0,roles2,projectss,projectss))

        if (GlobalVar.users.size > 0){
            iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
        }
        GlobalVar.users.add(user(iduser,"Kevin","password","vincent@email.com","Premium",0,0,0,roles3,projectss,projectss))

        if (GlobalVar.users.size > 0){
            iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
        }
        GlobalVar.users.add(user(iduser,"Ileene","password","vincent@email.com","Premium",0,0,0,roles4,projectss,projectss))

        if (GlobalVar.users.size > 0){
            iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
        }
        GlobalVar.users.add(user(iduser,"Hagen","password","vincent@email.com","Premium",0,0,0,roles5,projectss,projectss))

        val replies1=ArrayList<reply>()
        replies1.add(reply(1,"I'm fine with the original contract"))
        replies1.add(reply(1,"I think I'll do finw with the city's minumum wage"))

        val replies2=ArrayList<reply>()
        replies2.add(reply(1,"Let's start a meeting tomorrow"))
        replies2.add(reply(1,"I have an idea, I'll tell you guys about it tonight"))


        val discussions=ArrayList<discussion>()
        discussions.add(discussion("Salary","How much is salary",0,replies1))
        discussions.add(discussion("WorkPlan","We need to come up with our work plan, any ideas?",0,replies2))

//        var date = LocalDate.parse("2022-12-01")
//        var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
//        var formattedDate = date.format(formatter)
        var formattedDate = "01 December 2022"


        val tasks=ArrayList<task>()
        tasks.add(task("Make Project Prototype","An accurate prototype to pitch investors",formattedDate,0,"N"))
        tasks.add(task("Make Project BMC","BMC and Project idea plans",formattedDate,0,"Y"))
        tasks.add(task("Make Project Prototype 2","An accurate prototype to pitch investors",formattedDate,0,"N"))
        tasks.add(task("Make Project BMC 2","BMC and Project idea plans",formattedDate,0,"Y"))



        val files=ArrayList<files>()
        files.add(files("Source.pdf","","ini adalah file pertama",""))
        files.add(files("Database.pdf","","ini adalah file kedua",""))
        files.add(files("BMC.pdf","","ini adalah file pertama",""))
        files.add(files("Presentation.pptx","","ini adalah file kedua",""))
        GlobalVar.projects.add(
            projects(0,"Level Up","logolvlup","LevelUp Project Collaboration and Media Mobile Application","Project is started with an android based application","9 Oktober 2022", roles1,discussions ,tasks,
                arrayListOf(),0,files)
        )
        GlobalVar.projects[GlobalVar.projects.size-1].enrolleduser.add(0)
        GlobalVar.projects[GlobalVar.projects.size-1].enrolleduser.add(1)
        GlobalVar.projects[GlobalVar.projects.size-1].enrolleduser.add(2)
        GlobalVar.projects[GlobalVar.projects.size-1].enrolleduser.add(3)
        GlobalVar.projects[GlobalVar.projects.size-1].enrolleduser.add(4)

        Log.d("projects", GlobalVar.projects.toString())

    }


}