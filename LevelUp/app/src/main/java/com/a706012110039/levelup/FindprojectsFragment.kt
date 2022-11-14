package com.a706012110039.levelup

import Database.GlobalVar
import adaptor.RecyclerViewJobsForYouAdapter
import adaptor.RecyclerViewNewsAdaptor
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.a706012110039.levelup.databinding.FragmentFindprojectsBinding
import com.a706012110039.levelup.databinding.FragmentHomeBinding
import model.discussion
import model.files
import model.projects
import model.task

class FindprojectsFragment : Fragment() {

    private lateinit var viewbind: FragmentFindprojectsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        viewbind = FragmentFindprojectsBinding.inflate(layoutInflater)
        setuprv()
        // Inflate the layout for this fragment
        return viewbind.root
    }

    fun setuprv(){
        val jobsAdaptor: RecyclerViewJobsForYouAdapter
        jobsAdaptor = RecyclerViewJobsForYouAdapter(GlobalVar.projects)
        viewbind.rvJobsforu.layoutManager = LinearLayoutManager(requireActivity().baseContext, LinearLayoutManager.VERTICAL, false)
        viewbind.rvJobsforu.adapter = jobsAdaptor
    }



}