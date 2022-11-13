package com.a706012110039.levelup.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.a706012110039.levelup.R
import com.a706012110039.levelup.databinding.FragmentFirstScreenBinding

class FirstScreen : Fragment() {
    private lateinit var viewbind: FragmentFirstScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewbind = FragmentFirstScreenBinding.inflate(layoutInflater)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        viewbind.textView42.setOnClickListener {
            viewPager?.currentItem = 1
        }

        return viewbind.root
    }

}