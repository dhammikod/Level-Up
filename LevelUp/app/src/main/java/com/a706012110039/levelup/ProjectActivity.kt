package com.a706012110039.levelup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import androidx.fragment.app.Fragment
import com.a706012110039.levelup.databinding.ActivityBottomnavbarActiityBinding.inflate
import com.a706012110039.levelup.databinding.ActivityProjectBinding

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


}