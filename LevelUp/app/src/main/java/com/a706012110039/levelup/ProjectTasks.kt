package com.a706012110039.levelup

import Database.GlobalVar
import Interface.CardListener
import adaptor.RecyclerViewProjectDsicussionsAdapter
import adaptor.RecylcerViewProjectTasksAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_project_discussion.*
import kotlinx.android.synthetic.main.fragment_project_tasks.*
import model.task

class ProjectTasks : Fragment(R.layout.fragment_project_tasks), CardListener {

    var listtodo = ArrayList<task>()
    var listdoneproject = ArrayList<task>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (i in 0..GlobalVar.projects[GlobalVar.projects.size-1].tasks.size-1){
            if (GlobalVar.projects[GlobalVar.projects.size-1].tasks[i].status == "N"){
            listtodo.add(GlobalVar.projects[GlobalVar.projects.size-1].tasks[i])}
        }

        for (i in 0..GlobalVar.projects[GlobalVar.projects.size-1].tasks.size-1){
            if (GlobalVar.projects[GlobalVar.projects.size-1].tasks[i].status == "Y"){
                listdoneproject.add(GlobalVar.projects[GlobalVar.projects.size-1].tasks[i])
            }
        }
        setupRecycler()
    }

    fun setupRecycler(){
        latetaskrv.layoutManager = GridLayoutManager(context, 1)
        latetaskrv.adapter = RecylcerViewProjectTasksAdapter(listtodo, this)

        donetaskrv.layoutManager = GridLayoutManager(context, 1)
        donetaskrv.adapter = RecylcerViewProjectTasksAdapter(listdoneproject, this)


    }

    override fun onCardClick(position: Int) {
        TODO("Not yet implemented")
    }


}

