package com.a706012110039.levelup

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.a706012110039.levelup.databinding.FragmentMyprojectsBinding

class MyprojectsFragment : Fragment() {
    private lateinit var viewbind: FragmentMyprojectsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewbind = FragmentMyprojectsBinding.inflate(layoutInflater)
        viewbind.cvOngoingdata.isVisible = false
        switcher()

        return viewbind.root
    }

    fun switcher(){
        viewbind.cvOngoing.setOnClickListener {
            viewbind.cvOngoing.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.bgselected))
            viewbind.textView27.setTextColor(resources.getColor(R.color.colorselected))
            viewbind.cvPast.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.bgnotselected))
            viewbind.textView25.setTextColor(resources.getColor(R.color.colornotselected))
            viewbind.cvOngoingdata.isVisible = true
            viewbind.cvpastproject1.isVisible = false
            viewbind.cardView8.isVisible = false
        }

        viewbind.cvPast.setOnClickListener {
            viewbind.cvPast.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.bgselected))
            viewbind.textView25.setTextColor(resources.getColor(R.color.colorselected))
            viewbind.cvOngoing.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.bgnotselected))
            viewbind.textView27.setTextColor(resources.getColor(R.color.colornotselected))
            viewbind.cvOngoingdata.isVisible = false
            viewbind.cardviewpastproject1.isVisible = true
            viewbind.cardView8.isVisible = true
        }
    }
}