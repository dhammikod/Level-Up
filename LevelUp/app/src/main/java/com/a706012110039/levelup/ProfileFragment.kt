package com.a706012110039.levelup

import Database.GlobalVar
import adaptor.RecyclerViewProfessionAdapter
import android.R
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.a706012110039.levelup.databinding.FragmentProfileBinding
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView
import kotlinx.android.synthetic.main.activity_bottomnavbar_actiity.*

class ProfileFragment : Fragment() {
    private lateinit var viewbind: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setupdata()

        viewbind.status.setOnClickListener {
            val Intent = Intent(activity, userStatus::class.java)
            startActivity(Intent)
        }

        viewbind.imageView5.setOnClickListener {
            val Intent = Intent(activity, SettingActivity::class.java)
            startActivity(Intent)
        }

        if(!tourguidefinished()) {
            tourguide()
        }

        return viewbind.root
    }

    private fun tourguidefinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("tourguideprofile", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished",false)
    }

    private fun tourguide(){
        tourguide1()
    }

    fun tourguide1(){
        TapTargetView.showFor(activity,  // `this` is an Activity
            TapTarget.forView(viewbind.imageView5, "This is Setting button", "you can edit your profile info here") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(R.color.holo_purple)
                .targetRadius(50)
                .drawShadow(true),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    tourguide2()
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide2()
                }
            })
    }

    fun tourguide2(){
        TapTargetView.showFor(activity,  // `this` is an Activity
            TapTarget.forView(viewbind.imageView13, "This is your profile", "This part contains all of your basic information such as name email and your current user status") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(R.color.holo_purple)
                .targetRadius(50)
                .drawShadow(true)
                .targetCircleColor(R.color.white),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    tourguide3()
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide3()
                }
            })
    }

    fun tourguide3(){
        TapTargetView.showFor(activity,  // `this` is an Activity
            TapTarget.forView(viewbind.rvProfession, "This is your interest", "you can only join projects that matches with your profession/interest, you can change them anytime in the settings page") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(R.color.holo_purple)
                .targetRadius(50)
                .drawShadow(true)
                .targetCircleColor(R.color.white),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    tourguide4()
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide4()
                }
            })
    }

    fun tourguide4(){
        TapTargetView.showFor(activity,  // `this` is an Activity
            TapTarget.forView(viewbind.textView18, "This is your statistics", "This part contains all of your basic information such as name email and your current user status") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(R.color.holo_purple)
                .drawShadow(true)
                .targetCircleColor(R.color.white)
                .transparentTarget(true)
                .targetRadius(90),  // Specify the target radius (in dp)

            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                    tourguide5()
                }
                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    super.onTargetDismissed(view, userInitiated)
                    tourguide5()
                }
            })
    }

    private fun tourguide5() {
        val sharedPref = requireActivity().getSharedPreferences("tourguideprofile", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished",true)
        editor.apply()

        TapTargetView.showFor(activity,
            TapTarget.forView(viewbind.feedback, "This is profile functions", "uou can easily enter settings page or also get help using the featues in this tab") // All options below are optional
                .tintTarget(false)
                .outerCircleColor(R.color.holo_purple)
                .transparentTarget(true)
                .targetRadius(70),
            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView) {
                    super.onTargetClick(view)
                }
            })
    }

    fun setupdata(){
        viewbind = FragmentProfileBinding.inflate(layoutInflater)
        viewbind.name.text = GlobalVar.users[GlobalVar.curuser].name
        viewbind.email.text = GlobalVar.users[GlobalVar.curuser].Email
        viewbind.status.text = GlobalVar.users[GlobalVar.curuser].statuspremium

        val professionadaptor: RecyclerViewProfessionAdapter
        professionadaptor = RecyclerViewProfessionAdapter(GlobalVar.users[GlobalVar.curuser].profession)
        viewbind.rvProfession.layoutManager = LinearLayoutManager(requireActivity().baseContext, LinearLayoutManager.HORIZONTAL, false)
        viewbind.rvProfession.adapter = professionadaptor



        val id: Int = this.getResources().getIdentifier("ic_baseline_person_24", "drawable", context?.getPackageName())
        viewbind.imageView13.setImageResource(id)

        viewbind.textView18.text = GlobalVar.users[GlobalVar.curuser].projectdone.toString()
        viewbind.textView20.text = GlobalVar.users[GlobalVar.curuser].filesuploaded.toString()
        viewbind.textView22.text = GlobalVar.users[GlobalVar.curuser].comments.toString()
    }

    override fun onResume() {
        super.onResume()
        viewbind.status.text = GlobalVar.users[GlobalVar.curuser].statuspremium
        viewbind.name.text = GlobalVar.users[GlobalVar.curuser].name
        viewbind.email.text = GlobalVar.users[GlobalVar.curuser].Email
    }
}