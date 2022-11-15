package com.a706012110039.levelup

import Database.GlobalVar
import Interface.CardListener
import adaptor.RecyclerViewJobsForYouAdapter
import adaptor.RecyclerViewNewsAdaptor
import android.content.Intent
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.a706012110039.levelup.databinding.FragmentFindprojectsBinding
import com.a706012110039.levelup.databinding.FragmentHomeBinding
import model.discussion
import model.files
import model.projects
import model.task

class FindprojectsFragment : Fragment(), CardListener {

    private lateinit var viewbind: FragmentFindprojectsBinding
    private lateinit var jobsAdaptor: RecyclerViewJobsForYouAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        viewbind = FragmentFindprojectsBinding.inflate(layoutInflater)
        setuprv()
        listener()
        // Inflate the layout for this fragment



        viewbind.searchViewJobsForYou.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                jobsAdaptor?.getFilter()?.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                jobsAdaptor?.getFilter()?.filter(newText);
                return true
            }

        })

        return viewbind.root
    }

    fun setuprv(){
//        val jobsAdaptor: RecyclerViewJobsForYouAdapter
        jobsAdaptor = RecyclerViewJobsForYouAdapter(GlobalVar.projects, this)
        viewbind.rvJobsforu.layoutManager = LinearLayoutManager(requireActivity().baseContext, LinearLayoutManager.VERTICAL, false)
        viewbind.rvJobsforu.adapter = jobsAdaptor
    }

    private fun listener() {
        viewbind.addDataFAB.setOnClickListener {
            val myIntent = Intent(activity, EnrollProject_Activity::class.java)
            startActivity(myIntent)
        }
    }

    override fun onCardClick(position: Int) {
        val myIntent = Intent(activity, EnrollProject_Activity::class.java).apply { putExtra("position", position) }
        startActivity(myIntent)
    }





}