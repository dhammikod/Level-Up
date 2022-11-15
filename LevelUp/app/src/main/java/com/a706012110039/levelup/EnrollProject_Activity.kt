package com.a706012110039.levelup

import Database.GlobalVar
import adaptor.RecyclerViewJobsForYouAdapter
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
        Uri.parse(GlobalVar.projects[position].logoproject)
//        if (project.logoproject.isNotEmpty()) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                baseContext.contentResolver.takePersistableUriPermission(
//                    Uri.parse(GlobalVar.projects[position].logoproject),
//                    Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
//                )
//            }
//        }
        open(project)
    }

    private fun open(project: projects) {
        viewbind.enrollTitle.text = project.title
        viewbind.enrollCreator.text = GlobalVar.users[position].name
        viewbind.enrollLogoproject.setImageURI(Uri.parse(GlobalVar.projects[position].logoproject))
        viewbind.enrollOverview.text = project.overview
        viewbind.enrollNeededprofession.text = project.neededprofession.toString()
    }

    private fun listener() {
        viewbind.enrollEnrollButton.setOnClickListener {
            finish() //TODO: Code Enroll
        }
    }
}