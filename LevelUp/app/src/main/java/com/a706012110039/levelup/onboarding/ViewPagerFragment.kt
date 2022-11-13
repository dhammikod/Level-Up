package com.a706012110039.levelup.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a706012110039.levelup.R
import com.a706012110039.levelup.databinding.FragmentViewPagerBinding
import com.a706012110039.levelup.onboarding.screens.FirstScreen
import com.a706012110039.levelup.onboarding.screens.SecondScreen
import com.a706012110039.levelup.onboarding.screens.ThirdScreen
import java.util.ArrayList

class ViewPagerFragment : Fragment() {
    private lateinit var viewbind: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewbind = FragmentViewPagerBinding.inflate(layoutInflater)

        val fragmentlist = arrayListOf<Fragment>(
        //di isi fragment
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter = ViewPagerAdapter(
            fragmentlist,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        viewbind.viewPager.adapter = adapter

        // Inflate the layout for this fragment
        return viewbind.root
    }


}