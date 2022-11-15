package com.a706012110039.levelup

import Database.GlobalVar
import Interface.CardListener
import adaptor.RecyclerViewFilesAdapter
import adaptor.RecyclerViewProjectDsicussionsAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_project_discussion.*
import kotlinx.android.synthetic.main.fragment_project_files.*

class ProjectFiles : Fragment(R.layout.fragment_project_files), CardListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var intent = activity?.intent?.getIntExtra("helena cantik",0)
        setupRecycler()

    }
    fun setupRecycler(){

        projectfilesrv.layoutManager = GridLayoutManager(context, 3)
        projectfilesrv.adapter = GlobalVar.projects[GlobalVar.projects.size-1].files?.let {
            RecyclerViewFilesAdapter(it, this)
        }
    }

    override fun onCardClick(position: Int) {
        TODO("Not yet implemented")
    }
}

