package com.a706012110039.levelup

import Database.GlobalVar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
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

        start()



    }

    private fun start(){
        binding.projectcreatortv.text = GlobalVar.users[GlobalVar.projects[GlobalVar.projects.size-1].creator].name
        binding.projecttitletv.text= GlobalVar.projects[GlobalVar.projects.size-1].title
        binding.projectnotestv.text= GlobalVar.projects[GlobalVar.projects.size-1].notes
        binding.projectstarttv.text= GlobalVar.projects[GlobalVar.projects.size-1].startdate
        binding.projectoverviewtv.text= GlobalVar.projects[GlobalVar.projects.size-1].overview
//        binding.projectimage.setImageURI(GlobalVar.projects[GlobalVar.projects.size-1].logoproject.toUri())
    }

}