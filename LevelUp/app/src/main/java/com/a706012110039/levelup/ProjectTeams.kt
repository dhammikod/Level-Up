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


class ProjectTeams : Fragment(R.layout.fragment_project_teams), CardListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    setupRecycler()

    }
    fun setupRecycler(){

        projectteamsrv.layoutManager = GridLayoutManager(context, 1)
        projectteamsrv.adapter = RecylcerViewProjectTeamsAdapter(Database.GlobalVar.users, this)

    }


    override fun onCardClick(position: Int) {
        TODO("Not yet implemented")
    }

}