package com.a706012110039.levelup

import Database.GlobalVar
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.a706012110039.levelup.databinding.FragmentSplashBinding
import model.*
import java.util.*
import kotlin.collections.ArrayList

class SplashFragment : Fragment() {
    private lateinit var viewbind: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewbind = FragmentSplashBinding.inflate(layoutInflater)

        viewbind.imageView.alpha = 0f


        viewbind.imageView.animate().setDuration(3000).alpha(1f).withEndAction{
            var iduser = 0
            if (GlobalVar.users.size > 0){
                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
            }
            GlobalVar.users.add(
                user(iduser,"quantum","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                    arrayListOf(), arrayListOf())
            )

            if (GlobalVar.users.size > 0){
                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
            }
            GlobalVar.users.add(
                user(iduser,"1","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                    arrayListOf(), arrayListOf())
            )

            if (GlobalVar.users.size > 0){
                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
            }
            GlobalVar.users.add(
                user(iduser,"2","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                    arrayListOf(), arrayListOf())
            )

            if (GlobalVar.users.size > 0){
                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
            }
            GlobalVar.users.add(
                user(iduser,"3","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                    arrayListOf(), arrayListOf())
            )

            if (GlobalVar.users.size > 0){
                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
            }
            GlobalVar.users.add(
                user(iduser,"4","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                    arrayListOf(), arrayListOf())
            )

            if (GlobalVar.users.size > 0){
                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
            }
            GlobalVar.users.add(
                user(iduser,"5","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                    arrayListOf(), arrayListOf())
            )

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
        GlobalVar.users.add(user(iduser,"Vincent","vincent@email.com","Premium",0,0,0,roles1,projectss,projectss))

        if (GlobalVar.users.size > 0){
            iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
        }
        GlobalVar.users.add(user(iduser,"Dhammiko","vincent@email.com","Premium",0,0,0,roles2,projectss,projectss))

        if (GlobalVar.users.size > 0){
            iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
        }
        GlobalVar.users.add(user(iduser,"Kevin","vincent@email.com","Premium",0,0,0,roles3,projectss,projectss))

        if (GlobalVar.users.size > 0){
            iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
        }
        GlobalVar.users.add(user(iduser,"Ileene","vincent@email.com","Premium",0,0,0,roles4,projectss,projectss))

        if (GlobalVar.users.size > 0){
            iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
        }
        GlobalVar.users.add(user(iduser,"Hagen","vincent@email.com","Premium",0,0,0,roles5,projectss,projectss))

        val replies1=ArrayList<reply>()
        replies1.add(reply(0,"I'm fine with the original contract"))
        replies1.add(reply(0,"I think I'll do finw with the city's minumum wage"))

        val replies2=ArrayList<reply>()
        replies2.add(reply(0,"Let's start a meeting tomorrow"))
        replies2.add(reply(0,"I have an idea, I'll tell you guys about it tonight"))


        val discussions=ArrayList<discussion>()
        discussions.add(discussion("Salary","How much is salary",0,replies1))
        discussions.add(discussion("WorkPlan","We need to come up with our work plan, any ideas?",0,replies2))
        val date = Date(
        )
        val tasks=ArrayList<task>()
        tasks.add(task("Make Project Prototype","An accurate prototype to pitch investors",date,0,"N"))
        tasks.add(task("Make Project BMC","BMC and Project idea plans",date,0,"Y"))
        tasks.add(task("Make Project Prototype 2","An accurate prototype to pitch investors",date,0,"N"))
        tasks.add(task("Make Project BMC 2","BMC and Project idea plans",date,0,"Y"))



        val files=ArrayList<files>()
        files.add(files("Source.pdf","","ini adalah file pertama"))
        files.add(files("Database.pdf","","ini adalah file kedua"))
        files.add(files("BMC.pdf","","ini adalah file pertama"))
        files.add(files("Presentation.pptx","","ini adalah file kedua"))
        GlobalVar.projects.add(
            projects(0,"Level Up","","LevelUp Project Collaboration and Media Mobile Application","Project is started with an android based application","9 Oktober 2022", roles1,discussions ,tasks,
                arrayListOf(),0,files)
        )
        GlobalVar.projects[GlobalVar.projects.size-1].enrolleduser?.add(0)
        GlobalVar.projects[GlobalVar.projects.size-1].enrolleduser?.add(1)
        GlobalVar.projects[GlobalVar.projects.size-1].enrolleduser?.add(2)
        GlobalVar.projects[GlobalVar.projects.size-1].enrolleduser?.add(3)
        GlobalVar.projects[GlobalVar.projects.size-1].enrolleduser?.add(4)

        Log.d("projects", GlobalVar.projects.toString())

    }


}