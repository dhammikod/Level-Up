package com.a706012110039.levelup

import Database.GlobalVar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.fragment.app.Fragment
import com.a706012110039.levelup.databinding.ActivityBottomnavbarActiityBinding.inflate
import com.a706012110039.levelup.databinding.ActivityProjectBinding
import model.*
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*
import kotlin.collections.ArrayList

class ProjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

    setcurfragment(ProjectOverview())

        dummydata()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.teammenu -> setcurfragment(ProjectTeams())
                R.id.overviewmenu -> setcurfragment(ProjectOverview())
                R.id.taskmenu -> setcurfragment(ProjectTasks())
                R.id.discussionmenu -> setcurfragment(ProjectDiscussion())
                R.id.filemenu -> setcurfragment(ProjectFiles())

            }
            true
        }


        }

    private fun setcurfragment(fragment: Fragment){
        this.supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameproject, fragment)
            commit()
        }

    }

    private fun dummydata(){
        val roles=ArrayList<String>()
        roles.add("Doctor")
        roles.add("Programmer")

        val projectss=ArrayList<Int>()
        projectss.add(0)
        projectss.add(1)

        GlobalVar.users.add(user(0,"Vincent","vincent@email.com","Premium",0,0,0,roles,projectss,projectss))

        GlobalVar.users.add(user(0,"Vincent","vincent@email.com","Premium",0,0,0,roles,projectss,projectss))

        GlobalVar.users.add(user(0,"Vincent","vincent@email.com","Premium",0,0,0,roles,projectss,projectss))

        val replies=ArrayList<reply>()
        replies.add(reply(0,"hellow"))
        replies.add(reply(0,"hi"))


        val discussions=ArrayList<discussion>()
        discussions.add(discussion("Salary","How much is salary",0,replies))
        discussions.add(discussion("Salary","How much is salary",0,replies))
        val date = Date(
        )
        val tasks=ArrayList<task>()
        tasks.add(task("Start","Plan to start",date,0,"Done"))
        tasks.add(task("Start","Plan to start",date,0,"Y"))

        Database.GlobalVar.projects.add(
            projects(0,"Projek 1","","Ini adalah dummy project pertama","Mohon join yuk","9 Oktober 2022", roles,discussions ,tasks,
                arrayListOf(),0)
        )
        GlobalVar.projects[GlobalVar.projects.size-1].discussion.add(discussions[0])
        GlobalVar.projects[0].enrolleduser.add(0)



    }




}