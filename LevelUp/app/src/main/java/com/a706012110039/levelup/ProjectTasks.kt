package com.a706012110039.levelup

import Database.GlobalVar
import Interface.CardListener
import adaptor.RecylcerViewProjectTasksAdapter
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.a706012110039.levelup.databinding.ActivityProjectBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_project_discussion.*
import kotlinx.android.synthetic.main.fragment_project_tasks.*
import kotlinx.android.synthetic.main.input_task_modal.*
import model.task
import java.util.*


class ProjectTasks : Fragment(R.layout.fragment_project_tasks), CardListener {

    var listtodo = ArrayList<task>()
    var listdoneproject = ArrayList<task>()
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



        val addbutton = dialog.findViewById<Button>(R.id.addtaskb)
        val tasktitle = dialog.findViewById<TextInputEditText>(R.id.tasktitleinputtext)
        val taskdesc = dialog.findViewById<TextInputEditText>(R.id.taskdescinputtext)
        val back = dialog.findViewById<ImageView>(R.id.imageView25)

        addbutton?.setOnClickListener(){
            var title = tasktitle?.text.toString()
            var desc = taskdesc?.text.toString()
            var date = Date(
            )
            if (title != "" && desc != ""){
                GlobalVar.projects[GlobalVar.projects.size-1].tasks.add(0, task(title,desc, date,0,"N"))
            }


            else{

            }



            dialog.dismiss()
            setupRecycler()
        }

        back?.setOnClickListener(){
            dialog.dismiss()
        }
    }
    override fun onCardClick(position: Int) {
        onResume()
        setupRecycler()
//        val ft: FragmentTransaction = this.beginTransaction()
//        if (Build.VERSION.SDK_INT >= 26) {
//            ft.setReorderingAllowed(false)
//        }
//        ft.detach(this).attach(this).commit()

        this.requireFragmentManager().beginTransaction().apply {
            replace(R.id.frameproject, ProjectTasks())
            commit()
        }
    }

}

