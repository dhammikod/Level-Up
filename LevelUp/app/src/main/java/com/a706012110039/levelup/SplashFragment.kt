package com.a706012110039.levelup

import Database.GlobalVar
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.a706012110039.levelup.databinding.FragmentSplashBinding
import model.*

class SplashFragment : Fragment() {
    private lateinit var viewbind: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewbind = FragmentSplashBinding.inflate(layoutInflater)

        viewbind.imageView.alpha = 0f


        viewbind.imageView.animate().setDuration(3000).alpha(1f).withEndAction{
            var iduser = 0
            if (GlobalVar.users.size > 0){
                iduser = GlobalVar.users[GlobalVar.users.size-1].id + 1
            }
            GlobalVar.users.add(
                user(iduser,"quantum","password","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                    arrayListOf(), arrayListOf())
            )

            GlobalVar.users.add(
                user(1,"1","password","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                    arrayListOf(), arrayListOf())
            )

            GlobalVar.users.add(
                user(2,"2","password","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                    arrayListOf(), arrayListOf())
            )

            GlobalVar.users.add(
                user(3,"3","password","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                    arrayListOf(), arrayListOf())
            )

            GlobalVar.users.add(
                user(4,"4","password","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                    arrayListOf(), arrayListOf())
            )

            GlobalVar.users.add(
                user(5,"5","password","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                    arrayListOf(), arrayListOf())
            )

            if(onboardingfinished()){
                findNavController().navigate(R.id.action_splashFragment_to_loginActivity)
                getActivity()?.finish()
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        }

        dummydata()
        // Inflate the layout for this fragment
        return viewbind.root
    }

    private fun onboardingfinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }

    fun dummydata(){

        val neededprofessionArray = ArrayList<String>()
        val discussionArray = ArrayList<discussion>()
        val tasksArray = ArrayList<task>()
        val enrolleduserArray = ArrayList<Int>()
        val filesArray = ArrayList<files>()

        GlobalVar.projects.add(projects(11,"Creative Design", "creative_des","","","",
            neededprofessionArray,discussionArray,tasksArray,enrolleduserArray,2, filesArray))

        GlobalVar.projects.add(projects(2,"Music Ally", "job_default","","","",
            neededprofessionArray,discussionArray,tasksArray,enrolleduserArray,3, filesArray))

        Log.d("projects", GlobalVar.projects.toString())

    }


}