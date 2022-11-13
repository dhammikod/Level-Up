package com.a706012110039.levelup.onboarding.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.a706012110039.levelup.R
import com.a706012110039.levelup.databinding.FragmentThirdScreenBinding

class ThirdScreen : Fragment() {
    private lateinit var viewbind: FragmentThirdScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewbind = FragmentThirdScreenBinding.inflate(layoutInflater)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        viewbind.textView42.setOnClickListener {
            onboardingdinished()
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginActivity)
            getActivity()?.finish()
        }

        return viewbind.root
    }

    private fun onboardingdinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished",true)
        editor.apply()
    }

}