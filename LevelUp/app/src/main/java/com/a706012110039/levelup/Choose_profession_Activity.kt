package com.a706012110039.levelup

import Database.GlobalVar
import Interface.CardListener
import adaptor.RecyclerViewProfessionAdapter
import adaptor.RecyclerviewChooseProfessionAdapter
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.a706012110039.levelup.databinding.ActivityChooseProfessionBinding
import kotlinx.android.synthetic.main.activity_choose_profession.*
import model.profession

class Choose_profession_Activity : AppCompatActivity(),CardListener {
    private lateinit var viewbind: ActivityChooseProfessionBinding
    private lateinit var professionadaptor: RecyclerviewChooseProfessionAdapter
    private var listprofession = ArrayList<profession>()
    private var selected = ArrayList<String>()
    private var edit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        viewbind = ActivityChooseProfessionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewbind.root)
        setdataprofession()
        getintent()
        viewbind.submit.setOnClickListener {
            if(!selected.isEmpty()){
                GlobalVar.users[GlobalVar.curuser].profession = selected

                if(!edit){
                    val Intent = Intent(this, BottomnavbarActiity::class.java)
                    startActivity(Intent)
                    chooseprofessionfinished()
                }
                finish()
            }else{
                Toast.makeText(this, "Please select at least 1 profession", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun getintent(){
        edit = intent.getBooleanExtra("edit",false)
        if(edit){
            selected = GlobalVar.users[GlobalVar.curuser].profession
            //clearing dummy data
            var sum: Int = 0
            for (i in 0..selected.size-1){
                if (selected[i].equals("Programmer")) sum +=1
            }

            for (i in 0..sum){
                selected.remove("Programmer")
            }

            //ticking if selected
            for (i in 0..listprofession.size-1){
               if(selected.contains(listprofession[i].nama)){
                   listprofession[i].isselected = true
               }else{
                   listprofession[i].isselected = false
               }
                professionadaptor.notifyDataSetChanged()
            }
        }

    }

    private fun chooseprofessionfinished(){
        val sharedPref = this.getSharedPreferences("selectprofession", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished",true)
        editor.apply()
    }

    fun setdataprofession(){
        listprofession.add(profession("UI/UX Designer", R.drawable.uiux,false))
        listprofession.add(profession("Developer",R.drawable.backend,false))
        listprofession.add(profession("Digital Creator",R.drawable.digitalc,false))
        listprofession.add(profession("Marketing",R.drawable.marketingm,false))
        listprofession.add(profession("Accounting",R.drawable.projectm,false))
        listprofession.add(profession("Database ",R.drawable.databasee,false))
        listprofession.add(profession("Nutritionist",R.drawable.nutritionist,false))


        professionadaptor = RecyclerviewChooseProfessionAdapter(listprofession,this)
        viewbind.rvProfessionselect.layoutManager = GridLayoutManager(this.baseContext, 3)
        viewbind.rvProfessionselect.adapter = professionadaptor

    }

    override fun onCardClick(position: Int) {
        if(!selected.contains(listprofession[position].nama)){
            selected.add(listprofession[position].nama)
            listprofession[position].isselected = true
        }else{
            selected.remove(listprofession[position].nama)
            listprofession[position].isselected = false
        }
        professionadaptor.notifyDataSetChanged()
    }
}