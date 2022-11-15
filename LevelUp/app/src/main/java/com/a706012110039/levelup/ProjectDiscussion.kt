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
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_project_discussion.*
import kotlinx.android.synthetic.main.fragment_project_teams.*
import kotlinx.android.synthetic.main.input_discussion_modal.*
import model.discussion


class ProjectDiscussion : Fragment(R.layout.fragment_project_discussion), CardListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onResume()
        setupRecycler()

        adddiscussion.setOnClickListener(){
            showinput()
        }

    }
    fun setupRecycler(){

        projectdiscussionsrv.layoutManager = GridLayoutManager(context, 1)
        projectdiscussionsrv.adapter = GlobalVar.projects[GlobalVar.projects.size-1].discussion?.let {
            RecyclerViewProjectDsicussionsAdapter(it, this)
        }
    }
    fun showinput(){
        val dialog = BottomSheetDialog(requireContext())
        dialog.setContentView(R.layout.input_discussion_modal)
        dialog.show()

        val addbutton = dialog.findViewById<Button>(R.id.adddiscussionb)
        val disctitle = dialog.findViewById<TextInputEditText>(R.id.discussiontitleinputtext)
        val discdesc = dialog.findViewById<TextInputEditText>(R.id.discussiondescinputtext)
        val back = dialog.findViewById<ImageView>(R.id.imageView27)
        addbutton?.setOnClickListener(){
            var title = disctitle?.text.toString()
            var desc = discdesc?.text.toString()

            if (title != "" && desc != ""){
                GlobalVar.projects[GlobalVar.projects.size-1].discussion.add(0, discussion(title,desc,GlobalVar.curuser,
                    arrayListOf()))
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


    override fun onResume() {
        super.onResume()
        projectdiscussionsrv.adapter?.notifyDataSetChanged()
        setupRecycler()
    }

    override fun onCardClick(position: Int) {
        val myIntent = Intent(context,ReplyDiscussion::class.java).apply{
                putExtra("position",position)
        }
        startActivity(myIntent)
    }

}