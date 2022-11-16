package com.a706012110039.levelup

import Database.GlobalVar
import Database.GlobalVar.Companion.curproject
import Interface.CardListener
import adaptor.RecyclerViewJobsForYouAdapter
import adaptor.RecyclerView_Projects_OnGoing
import adaptor.RecyclerView_Projects_Past
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.a706012110039.levelup.databinding.FragmentMyprojectsBinding

class MyprojectsFragment : Fragment(), CardListener {
    private lateinit var viewbind: FragmentMyprojectsBinding
    private lateinit var onGoingAdapter: RecyclerView_Projects_OnGoing
    private lateinit var pastAdapter: RecyclerView_Projects_Past
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewbind = FragmentMyprojectsBinding.inflate(layoutInflater)
        viewbind.rvProjectsPast.isVisible = true
        viewbind.rvProjectsOnGoing.isVisible = false
        switcher()
        setuprv()


        viewbind.searchViewMyProjects.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                onGoingAdapter?.getFilter()?.filter(query)
                pastAdapter?.getFilter()?.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                onGoingAdapter?.getFilter()?.filter(newText);
                pastAdapter?.getFilter()?.filter(newText);
                return true
            }

        })
        return viewbind.root
    }

    fun setuprv(){

        onGoingAdapter = RecyclerView_Projects_OnGoing(GlobalVar.projects, this)
        viewbind.rvProjectsOnGoing.layoutManager = LinearLayoutManager(requireActivity().baseContext, LinearLayoutManager.VERTICAL, false)
        viewbind.rvProjectsOnGoing.adapter = onGoingAdapter

        pastAdapter = RecyclerView_Projects_Past(GlobalVar.projects, this)
        viewbind.rvProjectsPast.layoutManager = LinearLayoutManager(requireActivity().baseContext, LinearLayoutManager.VERTICAL, false)
        viewbind.rvProjectsPast.adapter = pastAdapter
    }




    fun switcher(){
        viewbind.cvOngoing.setOnClickListener {
            viewbind.cvOngoing.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.bgselected))
            viewbind.onGoingTextView.setTextColor(resources.getColor(R.color.colorselected))
            viewbind.cvPast.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.bgnotselected))
            viewbind.pastTextView.setTextColor(resources.getColor(R.color.colornotselected))
            viewbind.rvProjectsOnGoing.isVisible = true
            viewbind.rvProjectsPast.isVisible = false
        }

        viewbind.cvPast.setOnClickListener {
            viewbind.cvPast.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.bgselected))
            viewbind.pastTextView.setTextColor(resources.getColor(R.color.colorselected))
            viewbind.cvOngoing.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.bgnotselected))
            viewbind.onGoingTextView.setTextColor(resources.getColor(R.color.colornotselected))
            viewbind.rvProjectsPast.isVisible = true
            viewbind.rvProjectsOnGoing.isVisible = false
        }
    }

    override fun onCardClick(position: Int) {
        val myIntent = Intent(context, ProjectActivity::class.java).apply { putExtra("position", position) }
        curproject = position
        startActivity(myIntent)
    }
}