package com.a706012110039.levelup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.fragment.app.Fragment
import com.a706012110039.levelup.databinding.ActivityBottomnavbarActiityBinding.inflate
import com.a706012110039.levelup.databinding.ActivityProjectBinding
import model.discussion
import model.projects
import model.reply
import model.task

class ProjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectBinding.inflate(layoutInflater)
        setContentView(binding.root)





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

        val replies=ArrayList<reply>()
        replies.add(reply(0,"hellow"))
        replies.add(reply(0,"hi"))


        val discussions=ArrayList<model.discussion>()
        discussions.add(discussion("Salary","How much is salary",0,replies))
        discussions.add(discussion("Salary","How much is salary",0,replies))

        val tasks=ArrayList<task>()
        tasks.add(task("Start","Plan to start","9 December 2022",0,"Done"))
        tasks.add(task("Start","Plan to start","9 December 2022",0,"Done"))

        Database.GlobalVar.projects.add(
            projects(0,"Projek 1","","Ini adalah dummy project pertama","Mohon join yuk","9 Oktober 2022", roles, discussions ,tasks,
                arrayListOf())
        )

        Database.GlobalVar.projects[0].enrolleduser.add(0)

        Database.GlobalVar.users[0].mycurprojects.add(0)



    }




}