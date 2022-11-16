package com.a706012110039.levelup

import Database.GlobalVar
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a706012110039.levelup.databinding.ActivityEnrollProjectBinding
import model.projects

class EnrollProject_Activity : AppCompatActivity() {

    private lateinit var viewbind : ActivityEnrollProjectBinding
    private var position = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbind = ActivityEnrollProjectBinding.inflate(layoutInflater)
        setContentView(viewbind.root)
        getintent()
        listener()
    }

    override fun onResume() {
        super.onResume()
        val project = GlobalVar.projects[position]
        open(project)
    }

    private fun getintent() {
        position = intent.getIntExtra("position", -1)
        val project = GlobalVar.projects[position]
        open(project)
    }

    private fun open(project: projects) {
        viewbind.enrollTitle.text = project.title
        viewbind.enrollCreator.text = "by " + GlobalVar.users[project.creator].name
        val context: Context = viewbind.enrollLogoproject.context
        val id: Int = context.resources.getIdentifier(project.logoproject, "drawable", context.packageName)
        viewbind.enrollLogoproject.setImageResource(id)
        viewbind.enrollOverview.text = project.overview
        viewbind.enrollNeededprofession.text = project.neededprofession.toString()
    }

    private fun listener() {
        viewbind.enrollEnrollButton.setOnClickListener {
            finish() //TODO: Code Enroll
        }
    }
}