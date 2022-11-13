package com.a706012110039.levelup

import Database.GlobalVar
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.a706012110039.levelup.databinding.FragmentSplashBinding
import model.user

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
                user(iduser,"quantum","quantunm@gmail.com","Free user",0,0,0, arrayListOf("UI/UX designer", "database manager", "front end"),
                    arrayListOf(), arrayListOf())
            )

            if(onboardingfinished()){
                findNavController().navigate(R.id.action_splashFragment_to_loginActivity)
                getActivity()?.finish()
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)
            }
        }
        // Inflate the layout for this fragment
        return viewbind.root
    }

    private fun onboardingfinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }

}