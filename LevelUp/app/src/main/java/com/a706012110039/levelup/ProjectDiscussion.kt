package com.a706012110039.levelup

import Database.GlobalVar
import Interface.CardListener
import adaptor.RecyclerViewProjectDsicussionsAdapter
import adaptor.RecylcerViewProjectTeamsAdapter
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_project_discussion.*
import kotlinx.android.synthetic.main.fragment_project_teams.*


class ProjectDiscussion : Fragment(R.layout.fragment_project_discussion), CardListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycler()

    }
    fun setupRecycler(){

        projectdiscussionsrv.layoutManager = GridLayoutManager(context, 1)
        projectdiscussionsrv.adapter = RecyclerViewProjectDsicussionsAdapter(GlobalVar.projects[GlobalVar.projects.size-1].discussion, this)
    }


    override fun onCardClick(position: Int) {
        val myIntent = Intent(context,ReplyDiscussion::class.java).apply{
                putExtra("position",position)
        }
        startActivity(myIntent)
    }

}