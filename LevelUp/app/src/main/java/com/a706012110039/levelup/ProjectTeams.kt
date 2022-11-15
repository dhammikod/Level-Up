package com.a706012110039.levelup

import Database.GlobalVar
import Interface.CardListener
import adaptor.RecylcerViewProjectTeamsAdapter
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_project_teams.*
import model.reply
import model.user


class ProjectTeams : Fragment(R.layout.fragment_project_teams), CardListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    setupRecycler()

    }
    fun setupRecycler(){
        val userss=ArrayList<user>()
        for(i in 0..GlobalVar.users.size-1){
            if(GlobalVar.projects[GlobalVar.projects.size-1].enrolleduser.contains(GlobalVar.users[i].id)){
                userss.add(GlobalVar.users[i])
            }
        }


//        for (i in GlobalVar.projects[GlobalVar.projects.size-1].enrolleduser){
//            if (GlobalVar.users[i].id == GlobalVar.projects[GlobalVar.projects.size-1].enrolleduser[i]){
//                userss.add(GlobalVar.users[i])
//            }
//        }
        projectteamsrv.layoutManager = GridLayoutManager(context, 1)
        projectteamsrv.adapter = RecylcerViewProjectTeamsAdapter(userss, this)

    }


    override fun onCardClick(position: Int) {
        TODO("Not yet implemented")
    }

}