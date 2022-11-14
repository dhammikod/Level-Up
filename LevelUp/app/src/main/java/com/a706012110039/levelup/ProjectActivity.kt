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
        listener()

        if(GlobalVar.users.size<3){
        dummydata()}

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

    private fun listener(){
      binding.imageView6.setOnClickListener(){
          this.finish()
      }

    }

    private fun dummydata(){
        val roles1=ArrayList<String>()
        roles1.add("Programmer")

        val roles2=ArrayList<String>()
        roles2.add("UI/UX Designer")

        val roles3=ArrayList<String>()
        roles3.add("Marketing Director")

        val roles4=ArrayList<String>()
        roles4.add("Finance Officer")

        val roles5=ArrayList<String>()
        roles5.add("Operational Coordinator")



        val projectss=ArrayList<Int>()
        projectss.add(0)
        projectss.add(1)

        GlobalVar.users.add(user(0,"Vincent","password","vincent@email.com","Premium",0,0,0,roles1,projectss,projectss))

        GlobalVar.users.add(user(0,"Dhammiko","password","vincent@email.com","Premium",0,0,0,roles2,projectss,projectss))

        GlobalVar.users.add(user(0,"Kevin","password","vincent@email.com","Premium",0,0,0,roles3,projectss,projectss))

        GlobalVar.users.add(user(0,"Ileene","password","vincent@email.com","Premium",0,0,0,roles4,projectss,projectss))

        GlobalVar.users.add(user(0,"Hagen","password","vincent@email.com","Premium",0,0,0,roles5,projectss,projectss))
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

        val files=ArrayList<files>()
        files.add(files("Source.pdf","","ini adalah file pertama"))
        files.add(files("Database.pdf","","ini adalah file kedua"))
        files.add(files("BMC.pdf","","ini adalah file pertama"))
        files.add(files("Presentation.pptx","","ini adalah file kedua"))
        Database.GlobalVar.projects.add(
            projects(0,"Level Up","","LevelUp Project Collaboration and Media Mobile Application","Project is started with an android based application","9 Oktober 2022", roles1,discussions ,tasks,
                arrayListOf(),0,files)
        )
//        GlobalVar.projects[GlobalVar.projects.size-1].discussion.add(discussions[1])
//        GlobalVar.projects[GlobalVar.projects.size-1].tasks.add(tasks[0])
//        GlobalVar.projects[GlobalVar.projects.size-1].tasks.add(tasks[1])
        GlobalVar.projects[0].enrolleduser?.add(0)



    }




}