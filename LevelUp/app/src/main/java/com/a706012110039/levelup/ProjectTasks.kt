package com.a706012110039.levelup

import Database.GlobalVar
import Interface.CardListener
import adaptor.RecylcerViewProjectTasksAdapter
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.app.Dialog
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.a706012110039.levelup.databinding.ActivityProjectBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.fragment_project_discussion.*
import kotlinx.android.synthetic.main.fragment_project_tasks.*
import kotlinx.android.synthetic.main.input_task_modal.*
import model.task
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class ProjectTasks : Fragment(R.layout.fragment_project_tasks), CardListener, DatePickerDialog.OnDateSetListener {

    var listtodo = ArrayList<task>()
    var listdoneproject = ArrayList<task>()
    var day = 0
    var month = 0
    var year = 0

    var sday = 0
    var smonth = 0
    var syear = 0

    private val cal = Calendar.getInstance()

    @RequiresApi(Build.VERSION_CODES.O)
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
    @RequiresApi(Build.VERSION_CODES.O)
    fun showinput(){
        val dialog = BottomSheetDialog(requireContext())
        dialog.setContentView(R.layout.input_task_modal)
        dialog.show()





        val addbutton = dialog.findViewById<Button>(R.id.addtaskb)
        val tasktitle = dialog.findViewById<TextInputEditText>(R.id.tasktitleinputtext)
        val taskdesc = dialog.findViewById<TextInputEditText>(R.id.taskdescinputtext)
        val back = dialog.findViewById<ImageView>(R.id.imageView25)
        val pdate = dialog.findViewById<Button>(R.id.pickdateb)

        addbutton?.setOnClickListener(){
            var title = tasktitle?.text.toString()
            var desc = taskdesc?.text.toString()


//            var date = LocalDate.parse("$sday-$smonth-$syear")
            var date = LocalDate.parse("2022-11-29")
            var formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
            var formattedDate = date.format(formatter)

            if (title != "" && desc != ""){
                GlobalVar.projects[GlobalVar.projects.size-1].tasks.add(0, task(title,desc, formattedDate,0,"N"))
            }


            else{

            }

            pdate?.setOnClickListener(){
                getDateCalendar()
                DatePickerDialog(requireContext(),this,year,month,day).show()


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

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        sday = dayOfMonth
        smonth=month
        syear=year
    }


    private fun getDateCalendar(){
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)

    }

    private fun pickdate(){


    }

}

