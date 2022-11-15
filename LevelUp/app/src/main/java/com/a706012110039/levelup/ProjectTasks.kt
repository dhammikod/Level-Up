package com.a706012110039.levelup

import Database.GlobalVar
import Interface.CardListener
import adaptor.RecyclerViewProjectDsicussionsAdapter
import adaptor.RecylcerViewProjectTasksAdapter
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.a706012110039.levelup.databinding.ActivityProjectBinding
import com.a706012110039.levelup.databinding.FragmentProfileBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_project_discussion.*
import kotlinx.android.synthetic.main.fragment_project_tasks.*
import model.task

class ProjectTasks : Fragment(R.layout.fragment_project_tasks), CardListener {

    var listtodo = ArrayList<task>()
    var listdoneproject = ArrayList<task>()
    private lateinit var viewbind: ActivityProjectBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        onResume()
        addtask.setOnClickListener(){
            showinput()
        }
    }

    fun setupRecycler(){
        latetaskrv.adapter = null
        donetaskrv.adapter = null
        listtodo.clear()
        listdoneproject.clear()


        for (i in 0..GlobalVar.projects[GlobalVar.projects.size-1].tasks.size-1){
        if (GlobalVar.projects[GlobalVar.projects.size-1].tasks[i].status == "N"){
            listtodo.add(GlobalVar.projects[GlobalVar.projects.size-1].tasks[i])}
    }

        for (i in 0..GlobalVar.projects[GlobalVar.projects.size-1].tasks.size-1){
            if (GlobalVar.projects[GlobalVar.projects.size-1].tasks[i].status == "Y"){
                listdoneproject.add(GlobalVar.projects[GlobalVar.projects.size-1].tasks[i])
            }
        }

        if (listtodo.size>0) {
            latetaskrv.layoutManager = GridLayoutManager(context, 1)
            latetaskrv.adapter = RecylcerViewProjectTasksAdapter(listtodo, this)
        }

        if (listdoneproject.size>0) {
            donetaskrv.layoutManager = GridLayoutManager(context, 1)
            donetaskrv.adapter = RecylcerViewProjectTasksAdapter(listdoneproject, this)
        }

    }


    override fun onResume() {
        super.onResume()
        setupRecycler()
    }
    fun showinput(){
        val dialog = BottomSheetDialog(requireContext())
        dialog.setContentView(R.layout.input_task_modal)
        dialog.show()
    }
    override fun onCardClick(position: Int) {
        onResume()
        setupRecycler()
    }


}

