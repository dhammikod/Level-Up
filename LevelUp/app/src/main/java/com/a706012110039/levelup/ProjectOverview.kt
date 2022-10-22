package com.a706012110039.levelup

import Database.GlobalVar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a706012110039.levelup.databinding.ActivityProjectBinding
import com.a706012110039.levelup.databinding.FragmentProjectOverviewBinding
import kotlinx.android.synthetic.main.fragment_project_overview.*
import model.*

class ProjectOverview : Fragment() {
    private lateinit var binding : FragmentProjectOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentProjectOverviewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val roles=ArrayList<String>()
        roles.add("Doctor")
        roles.add("Programmer")

        val projectss=ArrayList<Int>()
        projectss.add(0)
        projectss.add(1)

        GlobalVar.users.add(user(0,"Vincent","vincent@email.com","Premium",0,0,0,roles,projectss,projectss))


        val replies=ArrayList<reply>()
        replies.add(reply(0,"hellow"))
        replies.add(reply(0,"hi"))


        val discussions=ArrayList<model.discussion>()
        discussions.add(discussion("Salary","How much is salary",0,replies))
        discussions.add(discussion("Salary","How much is salary",0,replies))

        val tasks=ArrayList<task>()
        tasks.add(task("Start","Plan to start","9 December 2022",0,"Done"))
        tasks.add(task("Start","Plan to start","9 December 2022",0,"Y"))

        GlobalVar.projects.add(
            projects(0,"Projek 1","","Ini adalah dummy project pertama","Mohon join yuk","9 Oktober 2022", roles, discussions ,tasks,
                arrayListOf(),0)
        )

        GlobalVar.projects[0].enrolleduser.add(0)


        start()



    }

    private fun start(){
        binding.projectcreatortv.text = GlobalVar.users[GlobalVar.projects[GlobalVar.projects.size-1].creator].name
        binding.projecttitletv.text= GlobalVar.projects[GlobalVar.projects.size-1].title

    }

}